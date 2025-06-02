package Talleres.A5_rmi.servidor.clase;

import java.sql.*;
import java.util.ArrayList;

public class Consulta {

    public static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Carga el driver
            Class.forName("org.sqlite.JDBC");
            // Conecta a la base de datos (empleados.db)
            String ruta = System.getProperty("user.dir") + "/src/Talleres/A5_rmi/servidor/db/empleados.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            // Crea la consulta
            String sql = "SELECT id, nombre, correo, cargo, sueldo FROM empleado";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Recorre resultados y crea objetos Persona
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String cargo = rs.getString("cargo");
                double sueldo = rs.getDouble("sueldo");

                Persona p = new Persona(id, nombre, correo, cargo, sueldo);
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra recursos
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return lista;
    }

    public static String insertarPersona(Persona p) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB());
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO empleado (id, nombre, correo, cargo, sueldo) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setInt(1, p.getClave());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getCorreo());
            stmt.setString(4, p.getCargo());
            stmt.setDouble(5, p.getSueldo());
            stmt.executeUpdate();
            return "Empleado insertado correctamente.";
        } catch (Exception e) {
            return "Error al insertar: " + e.getMessage();
        }
    }

    public static String actualizarPersona(Persona p) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB());
             PreparedStatement stmt = conn.prepareStatement("UPDATE empleado SET nombre=?, correo=?, cargo=?, sueldo=? WHERE id=?")) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getCorreo());
            stmt.setString(3, p.getCargo());
            stmt.setDouble(4, p.getSueldo());
            stmt.setInt(5, p.getClave());
            int rows = stmt.executeUpdate();

            return (rows > 0) ? "Empleado actualizado." : "Empleado no encontrado.";
        } catch (Exception e) {
            return "Error al actualizar: " + e.getMessage();
        }
    }

    public static String eliminarPersona(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB());
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleado WHERE id=?")) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            return (rows > 0) ? "Empleado eliminado." : "Empleado no encontrado.";
        } catch (Exception e) {
            return "Error al eliminar: " + e.getMessage();
        }
    }

    private static String rutaDB() {
        return System.getProperty("user.dir") + "/src/Talleres/A5_rmi/servidor/db/empleados.db";
    }

}
