import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket clientSocket = serverSocket.accept();
        InputStream is = clientSocket.getInputStream(); //canal de entrada do servidor
        OutputStream os = clientSocket.getOutputStream(); //canal de saída de um servidor

        //objetos para lidar com streams de dados primitivos
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);

        int valor = dis.readInt();
        System.out.println(valor++);
        dos.writeInt(valor);


        serverSocket.close();
        clientSocket.close();

    }
}
