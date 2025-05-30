package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        MulticastSocket multicastSocket = new MulticastSocket(3000);
        InetAddress group = InetAddress.getByName("228.5.6.7");
        multicastSocket.joinGroup(group);

        System.out.println("Aguardando mensagens...");

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        multicastSocket.receive(datagramPacket);

        String dado = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("Recebido: " + dado);

        multicastSocket.leaveGroup(group);
        multicastSocket.close();
    }
}
