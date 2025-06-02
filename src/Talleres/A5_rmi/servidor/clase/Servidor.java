package Talleres.A5_rmi.servidor.clase;

import java.rmi.Remote;

public interface Servidor extends Remote {

    // Consultar id del empleado
    public String consultar(int id) throws Exception;

    // Tarea 5 (CRUD)
    public String crear(Persona p) throws Exception;
    public String actualizar(Persona p) throws Exception;
    public String eliminar(int id) throws Exception;
}
