package Talleres.A5_rmi.servidor.clase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws Exception {
        ArrayList<Persona> lista = Consulta.getPersonas();

        for (Persona persona : lista) {
            if (persona.getClave() == id) {
                return "Nombre:  " + persona.getNombre() + "\n"
                        + "Correo:  " + persona.getCorreo() + "\n"
                        + "Cargo:  " + persona.getCargo() + "\n"
                        + "Sueldo:  " + persona.getSueldo();
            }
        }

        return "No existen datos del empleado con id: " + id;
    }
}