package hilos.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAuto extends JFrame {
    private JLabel marca1;
    private JTextField texto1;

    private JLabel modelo1;
    private JTextField texto2;

    private JLabel precio1;
    private JTextField texto3;

    private JButton mostrar;

    public VentanaAuto() {
        setTitle("Selección Auto");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Etiqueta y campo de texto para Marca
        marca1 = new JLabel("Marca:");
        marca1.setBounds(10, 20, 80, 30);
        add(marca1);

        texto1 = new JTextField();
        texto1.setBounds(100, 20, 150, 30);
        add(texto1);

        // Etiqueta y campo de texto para Modelo
        modelo1 = new JLabel("Modelo:");
        modelo1.setBounds(10, 70, 80, 30);
        add(modelo1);

        texto2 = new JTextField();
        texto2.setBounds(100, 70, 150, 30);
        add(texto2);

        // Etiqueta y campo de texto para Precio
        precio1 = new JLabel("Precio:");
        precio1.setBounds(10, 120, 80, 30);
        add(precio1);

        texto3 = new JTextField();
        texto3.setBounds(100, 120, 150, 30);
        add(texto3);

        mostrar = new JButton("Procesar");
        mostrar.setBounds(90, 170, 100, 30);
        add(mostrar);

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = texto1.getText();
                String modelo = texto2.getText();
                String precio = texto3.getText();

                JOptionPane.showMessageDialog(null, "\nMarca: " + marca +
                                "\nModelo: " + modelo +
                                "\nPrecio: " + precio,
                        "Datos del vehiculo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAuto ventana = new VentanaAuto();
            ventana.setVisible(true);
        });
    }
}
