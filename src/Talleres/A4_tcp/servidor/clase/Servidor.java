package Talleres.A4_tcp.servidor.clase;

import Talleres.A4_serial.servicios.Servicio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

    //Metodo para capturar la fecha
    public static  String getFecha(String nombre) {
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return nombre + "\n Fecha y Hora de Ingreso registrada en el Servido: "
                + formato.format(date);
    }

    // Metodo para iniciar el servidor
    public static void procesarSolicitud(int puerto) throws Exception{
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de Fechas Corriendo....");

        while (true){
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            InputStream in = cliente.getInputStream();
            OutputStream out = cliente.getOutputStream();

            // Leer el nombre del empleado
            DataInputStream dis = new DataInputStream(in);
            String nombre = dis.readUTF();
            if (nombre.equals("x")) break;
            String resultado = Servidor.getFecha(nombre);
            System.out.println("Mensaje recibido exitosamente ");

            // Devolver la respuesta al cliente
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(resultado);
            cliente.close();
        }
        servidor.close();
    }
}
