package Talleres.A4_serial.test;

import Talleres.A4_serial.entidades.Persona;
import Talleres.A4_serial.servicios.Servicio;

import java.util.ArrayList;
import java.util.List;

public class TestPersona {

    public static void main(String[] args) throws Exception{
        Persona p = new Persona();
        p.setNombre("JJ");
        p.setFechaNacimiento("0202");
        p.setDireccion("T");
        Servicio servicio = new Servicio();
        servicio.escribir(p, "C:\\Users\\APP DISTRIBUIDAS\\IdeaProjects\\ProyectoJ_01\\src\\Talleres\\A4_serial\\binario.dat");

        /*Persona p2 = new Persona();
        p2.setNombre("Persona 2");
        p2.setFechaNacimiento("Fecha 2");
        p2.setDireccion("Direccion 2");

        Persona p3 = new Persona();
        p3.setNombre("Persona 3");
        p3.setFechaNacimiento("Fecha 3");
        p3.setDireccion("Direccion 3");

        List<Persona> lista = new ArrayList<>();
        lista.add(p);
        lista.add(p2);
        lista.add(p3);*/

        System.out.println(servicio.leer("C:\\Users\\APP DISTRIBUIDAS\\IdeaProjects\\ProyectoJ_01\\src\\Talleres\\A4_serial\\binario.dat"));
    }

}
