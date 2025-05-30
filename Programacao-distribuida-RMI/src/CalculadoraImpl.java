import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl implements Calculadora{



    public CalculadoraImpl() throws RemoteException {

    }

    @Override
    public int somar(int i, int j) throws RemoteException {
        return i+j;
    }

    @Override
    public int subtrair(int i, int j) throws RemoteException {
        return i-j;
    }
}
