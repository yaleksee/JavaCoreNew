package src.CHART.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.*;

public class ClientHandler {

    private Socket socket;
    private Server server;
    private AuthService authService;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private List<String> blackList;
    private boolean LogIn = false;
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());


    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            this.authService = new AuthServiceImpl();
            this.blackList = new CopyOnWriteArrayList<>();
            Handler h = new FileHandler("ClientHandler.log", true);
            h.setFormatter(new SimpleFormatter());
            h.setLevel(Level.ALL);
            logger.addHandler(h);

            ExecutorService service = Executors.newCachedThreadPool();
            Future future = service.submit(new Callable<Object>() {
                public Object call() {
                    try {
                        autorization();
                        sendMsg(History.loadHistory());
                        server.broadcast(ClientHandler.this, getNick() + " подключился");
                        logger.info(getNick() + " подключился");
                        read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        close();
                    }
                    return "";
                }
            });
            service.shutdown();

//            new Thread(() ->{
//                try {
//                    autorization();
//                    sendMsg(History.loadHistory());
//                    server.broadcast(this,getNick() + " подключился");
//                    read();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    close();
//                }
//            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read() {
        String msg = null;
        while (true) {
            try {
                String str = in.readUTF();
                if (str.equalsIgnoreCase("/end")) {
                    sendMsg("/serverclosed");
                    msg = nick + " отключился";
                    break;

                } else if (str.startsWith("/w")) {
                    String[] token = str.split(" ");
                    String string = " ";
                    for (String message : token) {
                        if (message == token[1]) string = "<" + message + "> ";
                        else string += " " + message;
                    }
                    sendMsg(nick + ": " + string);
                    msg = nick + " отправил личное соодщение " + token[1];
                    server.prvMsg(token[1], string);

                } else if ((str.startsWith("/blacklist "))) {
                    String[] tokens = str.split(" ");
                    blackList.add(tokens[1]);
                    sendMsg("Вы добавили пользователя с ником " + tokens[1] + " в черный список!");
                    msg = nick + " добавил пользователя " + tokens[1] + " в черный список!";

                } else if (str.startsWith("/rename")) {
                    String[] token = str.split(" ");
                    authService.changeNick(nick, token[1]);
                    server.broadcast(this, nick + " изменил ник на " + token[1]);
                    msg = nick + " изменил ник на " + token[1];
                    nick = token[1];
                    server.broadcastClientList();

                } else {
                    String[] token = str.split(" ");
                    String string = " ";
                    for (int i = 0; i < token.length; i++) {
                        if (Censored.censored(token[i])) {
                            token[i] = "[censored]";
                        }
                        string += " " + token[i];
                    }
                    History.addHistory(nick + ": " + string + "\n");
                    server.broadcast(this, nick + ": " + string);
                    msg = nick + " отправил сообщение";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info(msg);
        }
    }

    private void autorization() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] tokens = str.split(" ");
                String newNick = authService.getNick(tokens[1], tokens[2]);
                if (newNick != null) {
                    nick = newNick;
                    sendMsg("/authOK");
                    server.subscribe(this);
                    break;
                } else {
                    sendMsg("Неверный логин/пароль");
                }
                LogIn = true;
            }
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.unsubscribe(this);
    }

    void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }


}
