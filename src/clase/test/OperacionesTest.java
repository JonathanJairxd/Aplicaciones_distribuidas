package clase.test;

import clase.implementacion.Operacionesimpl;
import clase.interfaz.Operaciones;

import javax.swing.*;
import java.util.Scanner;

public class OperacionesTest {

    public static void main(String[] args) {
        System.out.println("Hola mundo");

        double x,y;

        Operaciones op = new Operacionesimpl();

        Scanner entidad = new Scanner(System.in);
        //Se pide el numero por consola
        //System.out.print("Ingresa el valor de x: ");
        //x = entidad.nextDouble();

        //Se pide el numerp por interfaz grafica
        x = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de x: "));

        System.out.print("Ingresa el valor de y: ");
        y = entidad.nextDouble();

        //Consola
        System.out.println("La suma es "+op.sumar(x,y));

        //Por interfaz gráfica
        JOptionPane.showMessageDialog(null,"La suma es "+op.sumar(x,y));

    }
}
