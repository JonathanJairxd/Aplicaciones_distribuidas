package Talleres.A2_hilos.clase;

import javax.swing.*;

public class ProcesoE implements Runnable {
    private String texto;

    public ProcesoE(String texto){
        this.texto = texto;
    }

    public void mensaje(String texto){
        JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, texto);
    }

    @Override
    public void run() {
        mensaje(texto);
    }
}
