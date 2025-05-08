package Talleres.A3_cliente.clase;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public String enviarNumeros(String IP, int puerto, int num1, int num2, String operacion ){

        String respuesta = "";

        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(IP);

            // Convertir los números a cadena y enviarlos
            String mensaje = num1 + "," + num2 + "," + operacion;
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, puerto);
            socket.send(packet);
            System.out.println("Mensaje enviado: " + mensaje);
            // Esperar respuesta del servidor
            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket respuestaPacket = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(respuestaPacket);
            respuesta = new String(respuestaPacket.getData(), 0, respuestaPacket.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return respuesta;
    }
}