import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(2000);
        Calculadora calc = new CalculadoraImpl();
        calc = (Calculadora) UnicastRemoteObject.exportObject(calc,0);
        registry.rebind("calculadora",calc);
        System.out.println("Servidor pronto e aguardando requisições...");
    }
}
