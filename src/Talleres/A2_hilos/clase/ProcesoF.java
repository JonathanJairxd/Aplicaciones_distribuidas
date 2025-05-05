package Talleres.A2_hilos.clase;

import javax.swing.*;

public class ProcesoF implements Runnable{
    private Auto auto;

    public ProcesoF(Auto auto){
        this.auto = auto;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null,
                "Marca: " + auto.getMarca() +
                        "\nModelo: " + auto.getModelo() +
                        "\nPrecio: " + auto.getPrecio(),
                "Datos del Auto", JOptionPane.INFORMATION_MESSAGE);
    }
}
