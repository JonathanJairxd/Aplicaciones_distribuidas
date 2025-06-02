package Talleres.A5_rmi.cliente.vista;

import Talleres.A5_rmi.cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;

public class VentanaCliente extends JFrame {

    private JTextField campoID, campoNombre, campoCorreo, campoCargo, campoSueldo;
    private JTextArea areaResultado;

    public VentanaCliente() {
        setTitle("Gestión de Empleados RMI");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear campos de texto
        campoID = new JTextField(5);
        campoNombre = new JTextField(15);
        campoCorreo = new JTextField(15);
        campoCargo = new JTextField(15);
        campoSueldo = new JTextField(10);

        // Crear botones
        JButton botonConsultar = new JButton("Consultar");
        JButton botonCrear = new JButton("Crear");
        JButton botonActualizar = new JButton("Actualizar");
        JButton botonEliminar = new JButton("Eliminar");

        // Crear área de resultado
        areaResultado = new JTextArea(10, 40);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        // Panel de entrada
        JPanel panelCampos = new JPanel(new GridLayout(6, 2, 5, 5));
        panelCampos.add(new JLabel("ID:"));
        panelCampos.add(campoID);
        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(campoNombre);
        panelCampos.add(new JLabel("Correo:"));
        panelCampos.add(campoCorreo);
        panelCampos.add(new JLabel("Cargo:"));
        panelCampos.add(campoCargo);
        panelCampos.add(new JLabel("Sueldo:"));
        panelCampos.add(campoSueldo);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonConsultar);
        panelBotones.add(botonCrear);
        panelBotones.add(botonActualizar);
        panelBotones.add(botonEliminar);

        // Añadir al frame
        add(panelCampos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Listeners de los botones
        botonConsultar.addActionListener(e -> consultarEmpleado());
        botonCrear.addActionListener(e -> crearEmpleado());
        botonActualizar.addActionListener(e -> actualizarEmpleado());
        botonEliminar.addActionListener(e -> eliminarEmpleado());
    }

    private void consultarEmpleado() {
        try {
            int id = Integer.parseInt(campoID.getText());
            String resultado = Cliente.consultar(id);
            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            mostrarError("ID debe ser un número entero.");
        } catch (Exception ex) {
            mostrarError("Error al consultar: " + ex.getMessage());
        }
    }

    private void crearEmpleado() {
        try {
            int id = Integer.parseInt(campoID.getText());
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            String cargo = campoCargo.getText();
            double sueldo = Double.parseDouble(campoSueldo.getText());

            String resultado = Cliente.crear(id, nombre, correo, cargo, sueldo);
            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            mostrarError("ID y Sueldo deben ser numéricos.");
        } catch (Exception ex) {
            mostrarError("Error al crear: " + ex.getMessage());
        }
    }

    private void actualizarEmpleado() {
        try {
            int id = Integer.parseInt(campoID.getText());
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            String cargo = campoCargo.getText();
            double sueldo = Double.parseDouble(campoSueldo.getText());

            String resultado = Cliente.actualizar(id, nombre, correo, cargo, sueldo);
            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            mostrarError("ID y Sueldo deben ser numéricos.");
        } catch (Exception ex) {
            mostrarError("Error al actualizar: " + ex.getMessage());
        }
    }

    private void eliminarEmpleado() {
        try {
            int id = Integer.parseInt(campoID.getText());
            String resultado = Cliente.eliminar(id);
            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            mostrarError("ID debe ser un número entero.");
        } catch (Exception ex) {
            mostrarError("Error al eliminar: " + ex.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
