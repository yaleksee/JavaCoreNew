package src.less13.chat2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    private static final String DEFAUL_HOST = "localhost"; // localhost:9999
    private static final int DEFAUL_PORT = 9999;

    public static void main(String[] args) {
        String host = DEFAUL_HOST;
        int port = DEFAUL_PORT;

        if (args.length > 0) {
            host = args[0];
        }
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.out.println("UnknowHost: " + host);
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error in/out host/port: " + host + " / " + port);
            System.exit(-1);
        }

        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Error get input");
            System.exit(-1);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String ln = null;
        try {
            while ((ln = reader.readLine()) != null) {
                writer.write(ln + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Error with writing message");
            System.exit(-1);
        }
    }

}
