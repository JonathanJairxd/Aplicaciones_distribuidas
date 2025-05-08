package Talleres.A3_cliente.vista;

import Talleres.A3_cliente.clase.Cliente;

import javax.swing.*;

public class Ventana extends JFrame {

    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JLabel lblResultado;

    public Ventana() {
        // Configuración de la ventana
        setTitle("Calculadora Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Crear los campos de texto
        txtNumero1 = new JTextField();
        txtNumero1.setBounds(50, 20, 200, 30);
        add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(50, 60, 200, 30);
        add(txtNumero2);

        // Botones para las operaciones
        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(50, 100, 80, 30);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(140, 100, 80, 30);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(50, 140, 100, 30);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(160, 140, 80, 30);
        add(btnDividir);

        // Etiqueta para mostrar el resultado
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 180, 200, 30);
        add(lblResultado);

        // Acción para el botón Sumar
        btnSumar.addActionListener(e -> calcular("sumar"));

        // Acción para el botón Restar
        btnRestar.addActionListener(e -> calcular("restar"));

        // Acción para el botón Multiplicar
        btnMultiplicar.addActionListener(e -> calcular("multiplicar"));

        // Acción para el botón Dividir
        btnDividir.addActionListener(e -> calcular("dividir"));
    }

    // Método para enviar la solicitud de operación al servidor
    private void calcular(String operacion) {
        String ipServidor = "192.168.56.1"; // Dirección IP del servidor
        int puerto = 5000; // Puerto del servidor

        try {
            // Obtener los números ingresados
            int num1 = Integer.parseInt(txtNumero1.getText());
            int num2 = Integer.parseInt(txtNumero2.getText());

            // Crear el objeto Cliente y enviar los datos al servidor
            Cliente cliente = new Cliente();
            String resultado = cliente.enviarNumeros(ipServidor, puerto, num1, num2, operacion);

            // Mostrar el resultado en la etiqueta
            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa números válidos.");
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
