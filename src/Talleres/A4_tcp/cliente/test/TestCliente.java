package Talleres.A4_tcp.cliente.test;

import Talleres.A4_tcp.cliente.clase.Cliente;

import java.util.Scanner;

public class TestCliente {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println(Cliente.enviarNombre(nombre));
    }
}
