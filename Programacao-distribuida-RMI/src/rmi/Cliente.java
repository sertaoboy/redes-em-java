package rmi;

import java.rmi.Naming;
import java.rmi.Remote;

public class Cliente {

    public static void main(String[] args) throws Exception {
        Calculadora c = (Calculadora) Naming.lookup("rmi://localhost:2000/calculadora");
        System.out.println(c.somar(100,50));
        System.out.println(c.subtrair(30,20));


    }
}
