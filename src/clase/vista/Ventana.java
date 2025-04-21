package clase.vista;

import clase.implementacion.Operacionesimpl;
import clase.interfaz.Operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField resultField;

    public Ventana() {
        // Configuración de la ventana principal
        setTitle("Calculadora");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Crear los componentes (textFields y botones)
        textField1 = new JTextField();
        textField2 = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false); // No se puede editar el campo de resultado

        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMultiplicar = new JButton("*");
        JButton btnDividir = new JButton("/");

        // Agregar los componentes al panel
        panel.add(new JLabel("Número 1:"));
        panel.add(textField1);
        panel.add(new JLabel("Número 2:"));
        panel.add(textField2);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultField);
        panel.add(btnSuma);
        panel.add(btnResta);
        panel.add(btnMultiplicar);
        panel.add(btnDividir);

        // Añadir el panel a la ventana
        add(panel);

        // Crear instancia de la clase que implementa Operaciones
        Operaciones operaciones = new Operacionesimpl();

        // Acciones de los botones
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion(operaciones, '+');
            }
        });
        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion(operaciones, '-');
            }
        });
        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion(operaciones, '*');
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion(operaciones, '/');
            }
        });
    }

    // Metodo para realizar la operación
    private void realizarOperacion(Operaciones operaciones, char operacion) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double resultado = 0;

            switch (operacion) {
                case '+':
                    resultado = operaciones.sumar(num1, num2);
                    break;
                case '-':
                    resultado = operaciones.restar(num1, num2);
                    break;
                case '*':
                    resultado = operaciones.multiplicar(num1, num2);
                    break;
                case '/':
                    resultado = operaciones.dividir(num1, num2);
                    break;
            }
            resultField.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ventana = new Ventana();
            ventana.setVisible(true);
        });
    }
}
