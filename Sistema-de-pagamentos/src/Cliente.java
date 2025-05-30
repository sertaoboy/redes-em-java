import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",2000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // dados de entrada do cliente
        PrintWriter out = new PrintWriter(socket.getOutputStream()); //dados de saída para o servidor

        System.out.println("Enviando dados do pagamento ao servidor...");

        out.println("PAGAMENTO");
        out.flush();
        out.println(3);
        out.flush();
        out.println("João da Silva;3432356754323456;10/2012;2;512.45");
        out.println("Jorge Alexandre;9999544322250005;04/2025;1;24.90");
        out.println("Cristina Rocha;4904323956643203;12/2025;1;150.00");


        out.flush();

        String status = in.readLine();

        if(status.equals("OK")) {
            System.out.println("Pagamento realizado com sucesso.");
        } else {
            System.out.println("Falha no pagamento: " + status);
        }
        socket.close();
    }
}
