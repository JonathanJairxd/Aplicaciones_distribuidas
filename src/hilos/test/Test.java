package hilos.test;

import hilos.clase.*;

import javax.swing.*;

public class Test {
    public static void main (String [] args){
        Persona p = new Persona();
        p.setNombre("Jonathan Ramirez");
        p.setFechaNacimiento("02 de octubre del 2025");
        p.setDireccion("Quito, Tumbaco El Arenal");


        System.out.println("Nombre: "+ p.getNombre());
        System.out.println("Fecha de nacimiento: "+ p.getFechaNacimiento());
        System.out.println("Dirección: "+ p.getDireccion());

        /*
        ProcesoA a = new ProcesoA("Jonathan");
        ProcesoB b = new ProcesoB(10);
        ProcesoC c = new ProcesoC(5);
        Runnable x = new ProcesoD(50);
        Thread d = new Thread(x);
        Runnable y = new Proceso("Hola ¿Cómo estás?");
        Thread e = new Thread(y);

        c.start();
        a.start();
        b.start();
        d.start();
        e.start(); */

    }
}
