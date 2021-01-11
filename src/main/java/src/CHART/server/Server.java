package src.CHART.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.*;

class StartServer {

    public static void main(String[] args) throws IOException {
        new Server();
    }
}

class Server {
    private List<ClientHandler> peers;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    Server() {
        AuthService authService = new AuthServiceImpl();
        peers = new CopyOnWriteArrayList<>();
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            Handler h = new FileHandler("Server.log", true);
            h.setFormatter(new SimpleFormatter());
            h.setLevel(Level.ALL);
            logger.addHandler(h);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            authService.connect();
            serverSocket = new ServerSocket(8181);
            System.out.println("Сервер запущен!");
            logger.info("Сервер запущен!");
            while (true) {
                socket = serverSocket.accept();

                System.out.println("Клиент подключился!");

                ClientHandler clientHandler = new ClientHandler(this, socket);
                logger.info("Клиент подключился!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            authService.disconnect();
        }
    }

    void broadcast(ClientHandler from, String message) {
        for (ClientHandler clientHandler : peers) {
            if (!clientHandler.checkBlackList(from.getNick())) {
                clientHandler.sendMsg(message);
            }
        }
    }

    void prvMsg(String nick, String message) {
        for (ClientHandler clientHandler : peers) {
            if (clientHandler.getNick().equals(nick)) {
                clientHandler.sendMsg(clientHandler.getNick() + ": " + message);
            }
        }
    }

    void subscribe(ClientHandler clientHandler) {
        peers.add(clientHandler);
        broadcastClientList();
    }

    void unsubscribe(ClientHandler clientHandler) {
        peers.remove(clientHandler);
    }

    void broadcastClientList() {
        StringBuffer sb = new StringBuffer();
        sb.append("/clientlist ");
        for (ClientHandler clientHandler : peers) {
            sb.append(clientHandler.getNick() + " ");
        }
        String out = sb.toString();
        for (ClientHandler clientHandler : peers) {
            clientHandler.sendMsg(out);
        }
    }
}
