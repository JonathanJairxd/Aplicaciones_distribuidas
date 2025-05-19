package Talleres.A4_tcp_vista.servidor.clase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    // Metodo para capturar la fecha y registrar el nombre con fecha y hora
    public static String getFecha(String nombre) {
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return nombre + "\n Fecha y Hora de Ingreso registrada en el Servidor: "
                + formato.format(date);
    }

    // Clase interna para representar el registro que se guardará
    // Esta clase no es parte de tu código original, pero es necesaria para la serialización
    static class Registro implements Serializable {
        private String nombre;
        private String fechaHora;

        public Registro(String nombre, String fechaHora) {
            this.nombre = nombre;
            this.fechaHora = fechaHora;
        }

        @Override
        public String toString() {
            return nombre + " - " + fechaHora;
        }
    }

    // Metodo para guardar los registros en el archivo
    public static void guardarRegistro(Registro registro, String ruta) throws Exception {
        List<Registro> listaRegistros;

        // Comprobar si el archivo ya existe, y leer los registros previos
        File archivo = new File(ruta);
        if (archivo.exists()) {
            listaRegistros = leerRegistros(ruta);
        } else {
            listaRegistros = new ArrayList<>();
        }

        listaRegistros.add(registro); // Añadir el nuevo registro

        // Guardar la lista actualizada en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(listaRegistros);
        }
    }

    // Metodo para leer los registros desde el archivo
    public static List<Registro> leerRegistros(String ruta) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<Registro>) ois.readObject();
        }
    }

    // Metodo para procesar las solicitudes de los clientes
    public static void procesarSolicitud(int puerto) throws Exception {
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de Fechas Corriendo....");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");

            InputStream in = cliente.getInputStream();
            OutputStream out = cliente.getOutputStream();

            // Leer el nombre del cliente (empleado)
            DataInputStream dis = new DataInputStream(in);
            String nombre = dis.readUTF();
            if (nombre.equals("x")) break;

            // Generar la fecha y hora actual para el registro
            String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            String resultado = getFecha(nombre);

            // Crear el objeto Registro y guardarlo en el archivo
            Registro registro = new Registro(nombre, fechaHora);
            guardarRegistro(registro, "Reporte.data");

            System.out.println("Mensaje recibido exitosamente y registrado: " + resultado);

            // Devolver la respuesta al cliente
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(resultado);

            cliente.close();
        }
        servidor.close();
    }

}