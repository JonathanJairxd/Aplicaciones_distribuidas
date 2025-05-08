package Talleres.A3_servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public void servicio() {

        int port = 5000;

        try {

            DatagramSocket socket = new DatagramSocket(port); // Crear socket UDP en el puerto 5000
            System.out.println("Servidor UDP iniciado en el puerto " + port);

            byte[] buffer = new byte[1024]; // Convertir el mensaje a bytes

            while (true) {
                // Recibir datagrama del cliente
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Procesar datagrama
                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                // Procesar el mensaje
                String[] numeros = mensaje.split(",");
                if (numeros.length == 3) {
                    try {
                        int numero1 = Integer.parseInt(numeros[0]);
                        int numero2 = Integer.parseInt(numeros[1]);
                        String operacion = numeros[2];
                        int resultado;
                        // Realizar la operación
                        switch (operacion) {
                            case "sumar":
                                resultado = numero1 + numero2;
                                System.out.println("Realizando suma: " + numero1 + " + " + numero2);
                                break;
                            case "restar":
                                resultado = numero1 - numero2;
                                System.out.println("Realizando resta: " + numero1 + " - " + numero2);
                                break;
                            case "multiplicar":
                                resultado = numero1 * numero2;
                                System.out.println("Realizando multiplicación: " + numero1 + " * " + numero2);
                                break;
                            case "dividir":
                                if (numero2 != 0) {
                                    resultado = numero1 / numero2;
                                    System.out.println("Realizando división: " + numero1 + " / " + numero2);
                                } else {
                                    System.out.println("Error: División por cero");
                                    continue; // Salta al siguiente ciclo si hay error
                                }
                                break;
                            default:
                                System.out.println("Operación no válida");
                                continue; // Salta al siguiente ciclo si la operación no es válida
                        }

                        String respuesta = String.valueOf(resultado);
                        byte[] respuestaBytes = respuesta.getBytes();

                        DatagramPacket respuestaPacket = new DatagramPacket(
                                respuestaBytes,
                                respuestaBytes.length,
                                packet.getAddress(),
                                packet.getPort());
                        socket.send(respuestaPacket);
                        System.out.println("Respuesta enviada: " + respuesta);

                    } catch (Exception e) {
                        System.out.println("Error al procesar los números: " + e.getMessage());
                        String respuesta = "Error al procesar los números";
                        byte[] respuestaBytes = respuesta.getBytes();
                        DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                        socket.send(respuestaPacket);
                        System.out.println("Respuesta enviada: " + respuesta);
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}