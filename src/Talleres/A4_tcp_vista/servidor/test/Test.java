package Talleres.A4_tcp_vista.servidor.test;

import Talleres.A4_tcp_vista.servidor.clase.Servidor;

public class Test {
    public static void main(String[] args) throws Exception {
        Servidor.procesarSolicitud(5000);

        // Pausar para que el servidor tenga tiempo de procesar y luego mostrar los registros
        Thread.sleep(2000);
        Servidor.verRegistros("src/ReporteEmpleado.data");
    }
}
