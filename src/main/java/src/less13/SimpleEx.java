package src.less13;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SimpleEx {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("ya.ru");
            System.out.println("ip: " + address.getHostAddress() + " hostName: " + address.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }
    }
}
