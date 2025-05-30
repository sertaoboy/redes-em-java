import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorPagamento {


    public void efetuarPagamento(BufferedReader in, PrintWriter out)  {
        int quantidadeDePagamentos;
        try {
            quantidadeDePagamentos =  Integer.parseInt(in.readLine());
        } catch (IOException e ) {
            out.println("FALHA " + e.getMessage());
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        for(int i = 0; i< quantidadeDePagamentos;i++) {
            try {
                String dados = in.readLine();

                String [] tokens = dados.split(";");
                String nomeCliente = tokens[0];
                String numeroCartao = tokens[1];

                Date dataValidadeCartao = simpleDateFormat.parse(tokens[2]);
                int numeroDeParcelas = Integer.parseInt(tokens[3]);
                double valorCompra = Double.parseDouble(tokens[4]);

                System.out.println("Pagamento: " + (i+1));
                System.out.println("Nome cliente: " + nomeCliente);
                System.out.println("Número cartão: " + numeroCartao);
                System.out.println("Data validade: " + dataValidadeCartao);
                System.out.println("Número de parcelas: " + numeroDeParcelas);
                System.out.println("Valor da compra: R$"+ valorCompra);
                Thread.sleep(1000);
                out.println("OK");
                out.flush();
                System.out.println();
            } catch (Exception e) {
                out.println("FALHA " +e.getMessage());
                out.flush();
            }
        }
    }

    public void iniciar()throws Exception {
        ServerSocket serverSocket = new ServerSocket(2000);
        while (true) {
            Socket clientSocket = null;
            try {
                System.out.println("Aguardando requisições...");
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                String operacao = in.readLine();
                if(operacao.equals("PAGAMENTO")) {
                    efetuarPagamento(in,out);
                }else {
                    //implementar outras requisições
                }
            } finally {
                if(clientSocket != null) {
                    clientSocket.close();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ServidorPagamento().iniciar();
    }
}
