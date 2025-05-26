package Talleres.A5_rmi.cliente.vista;

import Talleres.A5_rmi.cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JFrame {

    private JTextField campoID;
    private JButton botonConsultar;
    private JTextArea areaResultado;

    public VentanaCliente() {
        setTitle("Consulta de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear componentes
        JLabel etiquetaID = new JLabel("ID del empleado:");
        campoID = new JTextField(10);
        botonConsultar = new JButton("Consultar");
        areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        // Panel de entrada
        JPanel panelEntrada = new JPanel();
        panelEntrada.add(etiquetaID);
        panelEntrada.add(campoID);
        panelEntrada.add(botonConsultar);

        // Añadir componentes al frame
        add(panelEntrada, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Acción del botón
        botonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarEmpleado();
            }
        });
    }

    private void consultarEmpleado() {
        try {
            int id = Integer.parseInt(campoID.getText());
            String resultado = Cliente.consultar(id);
            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar al servidor:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}