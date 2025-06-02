package Talleres.A5_rmi.cliente.clase;

import Talleres.A5_rmi.servidor.clase.Persona;
import Talleres.A5_rmi.servidor.clase.Servidor;

import java.rmi.Naming;

public class Cliente {

    public static String consultar(int id) throws Exception{

        String resultado = null;
        String rmiObjectName = "rmi://localhost/Datos";
        Servidor servicio = (Servidor) Naming.lookup(rmiObjectName);
        resultado = servicio.consultar(id);
        return  resultado;
    }

    public static String crear(int id, String nombre, String correo, String cargo, double sueldo) throws Exception {
        String resultado = null;
        String rmiObjectName = "rmi://localhost/Datos";
        Servidor servicio = (Servidor) Naming.lookup(rmiObjectName);
        Persona p = new Persona(id, nombre, correo, cargo, sueldo);
        resultado = servicio.crear(p);
        return resultado;
    }

    public static String actualizar(int id, String nombre, String correo, String cargo, double sueldo) throws Exception {
        String resultado = null;
        String rmiObjectName = "rmi://localhost/Datos";
        Servidor servicio = (Servidor) Naming.lookup(rmiObjectName);
        Persona p = new Persona(id, nombre, correo, cargo, sueldo);
        resultado = servicio.actualizar(p);
        return resultado;
    }

    public static String eliminar(int id) throws Exception {
        String resultado = null;
        String rmiObjectName = "rmi://localhost/Datos";
        Servidor servicio = (Servidor) Naming.lookup(rmiObjectName);
        resultado = servicio.eliminar(id);
        return resultado;
    }
}
