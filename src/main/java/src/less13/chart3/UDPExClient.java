package src.less13.chart3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPExClient {

    public static void main(String[] args) {


        DatagramSocket sock = null;
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

        try {
            sock = new DatagramSocket();

            while (true) {
                System.out.print("Please enter your message: ");
                String s = (String) cin.readLine();
                byte[] bytes = s.getBytes();

                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.103"), 7000);
                sock.send(dp);

                byte[] buffer = new byte[70000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

                sock.receive(reply);

                byte[] data = reply.getData();

                s = new String(data, 0, reply.getLength());
                System.out.println("Server: " + reply.getAddress().getHostAddress() + " port: " + reply.getPort() + " getMessage: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
