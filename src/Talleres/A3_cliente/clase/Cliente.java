package Talleres.A3_cliente.clase;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public void enviarNumeros(String IP, int puerto, int num1, int num2 ){

        try {
            DatagramSocket socket = new DatagramSocket(); // Crear Datagram
            InetAddress direccionIp_servidor = InetAddress.getByName(IP);

                // Crear mensaje en formato "num1,num2"
                String mensajeSalida = num1 + "," + num2;
                byte[] bufferSalida = mensajeSalida.getBytes();

                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_servidor, puerto);
                socket.send(paqueteSalida);

                // Esperar respuesta del servidor (la suma)
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                socket.receive(paqueteEntrada);

                String respuestaServidor = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Resultado recibido del servidor: " + respuestaServidor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}