import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {

     int somar(int i, int j) throws RemoteException;
     int subtrair(int i, int j) throws RemoteException;
}
