package src.less13.chart3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPExServer {
    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket(7000);
        byte[] buffer = new byte[70000];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        System.out.println(" waiting ... ");

        try {
            while (true) {
                socket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();

                String ln = new String(data, 0, datagramPacket.getLength());
                System.out.println("server recieved : " + ln);

                DatagramPacket dp = new DatagramPacket(ln.getBytes(), ln.getBytes().length, datagramPacket.getAddress(), datagramPacket.getPort());

                socket.send(dp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
