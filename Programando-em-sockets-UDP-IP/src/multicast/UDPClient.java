package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        String valor = "isto é um texto";
        byte[] bytes = valor.getBytes();

        int porta = 3000;
        InetAddress addr = InetAddress.getByName("192.168.1.65");

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, addr, porta);
        ds.send(dp);

        ds.close();


    }
}
