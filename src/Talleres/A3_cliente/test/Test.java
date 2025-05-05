package Talleres.A3_cliente.test;

import Talleres.A3_cliente.clase.Cliente;

public class Test {
    public static  void main(String[] args){
        Cliente c = new Cliente();
        c.enviarNumeros("192.168.56.101", 5000, 10, 12);
    }
}
