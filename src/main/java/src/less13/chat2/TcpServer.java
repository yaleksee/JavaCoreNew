package src.less13.chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private static final int DEFAUL_PORT = 9999;

    public static void main(String[] args) {
        int port = DEFAUL_PORT;
        if(args.length>0){
            port = Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
        }catch (IOException e){
            System.out.println("port busy: " + port);
            System.exit(-1);
        }

        Socket clientSocket = null;
        try{
            clientSocket = serverSocket.accept();
        }catch (IOException e){
            System.out.println("Error port connection: " + port);
            System.exit(-1);
        }

        InputStream inputStream = null;
        try{
            inputStream = clientSocket.getInputStream();
        } catch (IOException e){
            System.out.println("Error with reading message");
            System.exit(-1);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String ln = null;
        try{
            while ((ln=reader.readLine())!=null){
                System.out.println(ln);
                System.out.flush();
            }
        }catch (IOException e){
            System.out.println("Error with reading message");
            System.exit(-1);
        }

    }
}
