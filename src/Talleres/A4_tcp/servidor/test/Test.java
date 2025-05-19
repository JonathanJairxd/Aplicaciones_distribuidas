package Talleres.A4_tcp.servidor.test;

import Talleres.A4_tcp.servidor.clase.Servidor;

import java.net.DatagramPacket;

public class Test {
    public static void main(String[] args) throws Exception {

        //System.out.println(Servidor.getFecha("Jorgue"));

        Servidor.procesarSolicitud(5000);
    }
}
