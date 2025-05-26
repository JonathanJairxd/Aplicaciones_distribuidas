package Talleres.A5_rmi.servidor.test;

import Talleres.A5_rmi.servidor.clase.ServidorImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TestServidor {

    public static void main(String[] args) throws Exception {

        /*ServidorImpl servidor = new ServidorImpl();
        System.out.println(servidor.consultar(3));*/

        LocateRegistry.createRegistry(1099);
        ServidorImpl servidor = new ServidorImpl();
        String rmiObjectName = "rmi://localhost/Datos";
        Naming.rebind(rmiObjectName, servidor);
        System.out.println("Servidor Remoto corriendo");

    }
}
