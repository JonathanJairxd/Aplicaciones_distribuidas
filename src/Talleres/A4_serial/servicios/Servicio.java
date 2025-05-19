package Talleres.A4_serial.servicios;

import Talleres.A4_serial.entidades.Persona;

import java.io.FileInputStream;
import  java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class Servicio {
    public void escribir (Persona p, String ruta) throws Exception{
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();

    }

    // Solo guarda info de una persona
    /*public Persona leer(String ruta) throws Exception{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Persona p = (Persona)ois.readObject();
        ois.close();
        return p;
    }*/

    //Guarda de datos de varais personas
    public List<Persona> leer(String ruta) throws Exception{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Persona> lista = (List<Persona>) ois.readObject();
        ois.close();
        return lista;
    }
}
