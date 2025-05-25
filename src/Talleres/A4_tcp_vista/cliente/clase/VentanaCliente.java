package Talleres.A4_tcp_vista.cliente.clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JFrame {

    private JTextField campoNombre;
    private JComboBox<String> comboTipo;
    private JButton botonEnviar;
    private JTextArea areaRespuesta;
    private JButton botonVerRegistros;


    public VentanaCliente() {
        setTitle("Registro de Entrada");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(30, 30, 100, 25);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(150, 30, 200, 25);
        add(campoNombre);

        JLabel etiquetaTipo = new JLabel("Tipo de Registro:");
        etiquetaTipo.setBounds(30, 70, 120, 25);
        add(etiquetaTipo);

        comboTipo = new JComboBox<>(new String[]{"Ingreso al trabajo", "Salida al almuerzo", "Ingreso del Almuerzo" , "Salida del trabajo"});
        comboTipo.setBounds(150, 70, 200, 25);
        add(comboTipo);

        botonEnviar = new JButton("Enviar");
        botonEnviar.setBounds(150, 110, 100, 30);
        add(botonEnviar);

        botonVerRegistros = new JButton("Ver Registros");
        botonVerRegistros.setBounds(260, 110, 130, 30);
        add(botonVerRegistros);

        areaRespuesta = new JTextArea();
        areaRespuesta.setEditable(false);
        JScrollPane scrollArea = new JScrollPane(areaRespuesta);
        scrollArea.setBounds(75, 165, 345, 120);
        add(scrollArea);

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

        botonVerRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String registros = Cliente.verRegistros();
                    areaRespuesta.setText(registros);
                } catch (Exception ex) {
                    areaRespuesta.setText("Error al obtener los registros.");
                    ex.printStackTrace();
                }
            }
        });




        setVisible(true);
    }
}
