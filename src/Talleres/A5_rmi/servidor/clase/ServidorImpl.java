package Talleres.A5_rmi.servidor.clase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    private static ArrayList<Persona> listPersonas(){
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Jonathan Ramirez", "jr@empresa.com", "administrador", 2500));
        lista.add(new Persona(2, "Ariel Ashqui", "aa@empresa.com", "técnico 1", 1500));
        lista.add(new Persona(3, "Evelyn Guachamin", "eg@empresa.com", "secretaria 1", 2000));
        lista.add(new Persona(4, "Nebraska Mejia", "nm@empresa.com", "secretaria 2", 1500));
        lista.add(new Persona(5, "Jhonnatan Chuncho", "jch@empresa.com", "colaborador 1", 900));
        lista.add(new Persona(6, "Dayana Pachacama", "dp@empresa.com", "", 900));
        lista.add(new Persona(7, "Heidy Achig", "ha@empresa.com", "tecnica 2", 800));
        lista.add(new Persona(8, "Wilmer Bonilla", "wb@empresa.com", "colaborador 2", 900));

        return lista;
    }

    private static String getPersona(int id){
        return "Nombre:  "+ listPersonas().get(id-1).getNombre()+"\n"
                +"Correo:  "+ listPersonas().get(id-1).getCorreo()+"\n"
                +"Cargo:  "+ listPersonas().get(id-1).getCargo()+"\n"
                +"Sueldo:  "+ listPersonas().get(id-1).getSueldo();
    }

    public ServidorImpl() throws RemoteException { super(); }

    public String consultar(int id) throws Exception{
        if(id<listPersonas().size()+1){
            return getPersona(id);}
        else {
            return "No existen datos del emleado";
        }
    }

}
