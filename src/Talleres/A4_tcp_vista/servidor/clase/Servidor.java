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

    // Clase interna para representar el registro que se guardara
    // Esta clase no es parte de tu codigo original, pero es necesaria para la serialización
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

    // Metodo para mostrar los registros guardados en el archivo
    public static void verRegistros(String ruta) throws Exception {
        List<Registro> listaRegistros = leerRegistros(ruta);

        // Mostrar los registros de manera legible
        if (listaRegistros.isEmpty()) {
            System.out.println("No hay registros para mostrar.");
        } else {
            System.out.println("Registros guardados:");
            for (Registro registro : listaRegistros) {
                System.out.println(registro);
            }
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

            // Si el cliente solicita los registros
            if (nombre.equalsIgnoreCase("ver_registros")) {
                // Leer todos los registros y enviarlos como una cadena
                try {
                    List<Registro> registros = leerRegistros("src/ReporteEmpleado.data");
                    StringBuilder registrosTexto = new StringBuilder();
                    for (Registro registro : registros) {
                        registrosTexto.append(registro.toString()).append("\n");
                    }
                    if (registrosTexto.isEmpty()) {
                        registrosTexto.append("No hay registros para mostrar.");
                    }

                    DataOutputStream dos = new DataOutputStream(out);
                    dos.writeUTF(registrosTexto.toString());
                } catch (Exception e) {
                    DataOutputStream dos = new DataOutputStream(out);
                    dos.writeUTF("Error al leer registros: " + e.getMessage());
                }

                cliente.close();
                continue;  // Esperar al siguiente cliente
            }

            // Si el cliente envía un nombre para registrar
            if (nombre.equals("x")) break;

            // Generar la fecha y hora actual para el registro
            String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            String resultado = getFecha(nombre);

            // Crear el objeto registro y guardarlo en el archivo
            Registro registro = new Registro(nombre, fechaHora);
            guardarRegistro(registro, "src/ReporteEmpleado.data");

            System.out.println("Mensaje recibido exitosamente y registrado: " + resultado);

            // Devolver la respuesta al cliente
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(resultado);

            cliente.close();
        }
        servidor.close();
    }

}