package Talleres.A4_tcp_vista.cliente.clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JFrame {

    private JTextField campoNombre;
    private JComboBox<String> comboTipo;
    private JButton botonEnviar;
    private JTextArea areaRespuesta;

    public VentanaCliente() {
        setTitle("Registro de Entrada");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(30, 30, 100, 25);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(150, 30, 200, 25);
        add(campoNombre);

        JLabel etiquetaTipo = new JLabel("Tipo de Registro:");
        etiquetaTipo.setBounds(30, 70, 120, 25);
        add(etiquetaTipo);

        comboTipo = new JComboBox<>(new String[]{"Llegada", "Salida", "Hora de comida"});
        comboTipo.setBounds(150, 70, 200, 25);
        add(comboTipo);

        botonEnviar = new JButton("Enviar");
        botonEnviar.setBounds(150, 110, 100, 30);
        add(botonEnviar);

        areaRespuesta = new JTextArea();
        areaRespuesta.setBounds(30, 160, 320, 80);
        areaRespuesta.setEditable(false);
        add(areaRespuesta);

        // Evento del botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                String tipo = comboTipo.getSelectedItem().toString();
                if (!nombre.isEmpty()) {
                    try {
                        String respuesta = Cliente.enviarRegistro(nombre,tipo);
                        areaRespuesta.setText(respuesta);
                    } catch (Exception ex) {
                        areaRespuesta.setText("Error al conectar con el servidor.");
                        ex.printStackTrace();
                    }
                } else {
                    areaRespuesta.setText("Por favor, ingresa tu nombre.");
                }
            }
        });

        setVisible(true);
    }
}
