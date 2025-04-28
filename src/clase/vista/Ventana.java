package clase.vista;

import clase.implementacion.Operacionesimpl;
import clase.interfaz.Operaciones;

import javax.swing.*;

public class Ventana extends JFrame{
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JLabel lblResultado;

    public Ventana() {
        setTitle("Calculadora");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Operaciones op = new Operacionesimpl();

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(50, 20, 200, 30);
        add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(50, 60, 200, 30);
        add(txtNumero2);

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

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 180, 200, 30);
        add(lblResultado);

        // Action listeners for buttons
        btnSumar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = op.sumar(num1, num2);
            lblResultado.setText("Resultado: " + resultado);
        });

        btnRestar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = op.restar(num1, num2);
            lblResultado.setText("Resultado: " + resultado);
        });

        btnMultiplicar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = op.multiplicar(num1, num2);
            lblResultado.setText("Resultado: " + resultado);
        });

        btnDividir.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            if (num2 != 0) {
                double resultado = op.dividir(num1, num2);
                lblResultado.setText("Resultado: " + resultado);
            } else {
                lblResultado.setText("Error: División por cero");
            }
        });

    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}