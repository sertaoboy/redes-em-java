import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",3000);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //objetos para lidar com streams de dados primitivos
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos =new DataOutputStream(os);

        dos.writeInt(5);
        int valorIncrementado = dis.readInt();
        System.out.println(valorIncrementado);

        socket.close();
    }
}
