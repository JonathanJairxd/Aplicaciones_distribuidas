package Talleres.A4_tcp.cliente.clase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

    private static final int PUERTO = 5000;
    private static final String IP = "172.31.116.82";

    public static String enviarNombre(String nombre) throws Exception{
        Socket cliente = new Socket(IP, PUERTO);
        InputStream in = cliente.getInputStream();
        OutputStream out = cliente.getOutputStream();

        //Enviar datos al server
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(nombre);

        //Leer la respuesta
        DataInputStream dis = new DataInputStream(in);
        String respuesta = dis.readUTF();
        cliente.close();

        return respuesta;
    }

}
