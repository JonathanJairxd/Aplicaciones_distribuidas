package Talleres.A4_tcp_vista.cliente.clase;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private static final int PUERTO = 5000;
    private static final String IP = "127.0.0.1"; // Asegúrate de usar la IP correcta (127.0.0.1 si es local)

    public static String enviarRegistro(String nombre, String tipo) throws Exception {
        Socket cliente = new Socket(IP, PUERTO);
        InputStream in = cliente.getInputStream();
        OutputStream out = cliente.getOutputStream();

        // Crear el mensaje con nombre y tipo de registro
        String mensaje = nombre + " - " + tipo;

        // Enviar datos al servidor
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(mensaje);  // Enviar el mensaje con nombre y tipo

        // Leer la respuesta del servidor
        DataInputStream dis = new DataInputStream(in);
        String respuesta = dis.readUTF();
        cliente.close();

        return respuesta;
    }

    public static String verRegistros() throws Exception {
        Socket cliente = new Socket(IP, PUERTO);
        InputStream in = cliente.getInputStream();
        OutputStream out = cliente.getOutputStream();

        // Enviar comando para pedir los registros al servidor
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF("ver_registros");  // Mensaje especial para pedir los registros

        DataInputStream dis = new DataInputStream(in);
        String respuesta = dis.readUTF();  // El servidor debe devolver una cadena con todos los registros

        cliente.close();
        return respuesta;
    }

}
