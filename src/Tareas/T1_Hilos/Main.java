package Tareas.T1_Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCarrera();
            }
        });
    }
}

class Hilo implements Runnable{

    Thread t;
    String nombre;

    JLabel personaje;
    JLabel labelFinal;

    public static int lugar;

    public Hilo(String nombre, JLabel personaje, JLabel labelFinal){
        this.nombre = nombre;
        this.labelFinal = labelFinal;
        this.personaje = personaje;

        t = new Thread(this, nombre);
        t.start();
    }

    @Override
    public void run(){
        int retardo;
        try {
            lugar = 1;
            retardo = (int) (Math.random() * 15) +1;
            labelFinal.setVisible(false);
            personaje.setVisible(true);

            for (int i = 50; i <= 500 ; i++) {
                personaje.setLocation(i,personaje.getY());
                Thread.sleep(retardo);
            }
            personaje.setVisible(false);

            labelFinal.setVisible(true);
            labelFinal.setText(nombre +" ha llegado en la posición: N° "+ lugar);
            lugar++;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}

class VentanaCarrera extends JFrame{
    public VentanaCarrera(){
        super("Carrera de personajes");
        JLabel goku, pikachu, calamardo, goku_pos, pikachu_pos, calamardo_pos;
        JButton botonIniciarCarrera;

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Image imagen_goku = new ImageIcon("src/Tareas/T1_Hilos/img/goku.gif").getImage();
        ImageIcon Icon_goku = new ImageIcon(imagen_goku.getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        goku = new JLabel();
        goku.setIcon(Icon_goku);
        goku.setBounds(50,50,50,50);

        Image imagen_pikachu = new ImageIcon("src/Tareas/T1_Hilos/img/pikachu.gif").getImage();
        ImageIcon Icon_pikachu = new ImageIcon(imagen_pikachu.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        pikachu = new JLabel();
        pikachu.setIcon(Icon_pikachu);
        pikachu.setBounds(50,100,50,50);

        Image imagen_calamardo = new ImageIcon("src/Tareas/T1_Hilos/img/calamardo.gif").getImage();
        ImageIcon Icon_calamardo = new ImageIcon(imagen_calamardo.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        calamardo = new JLabel();
        calamardo.setIcon(Icon_calamardo);
        calamardo.setBounds(50,150,50,50);

        goku_pos = new JLabel();
        goku_pos.setBounds(50,50,350,50);

        pikachu_pos = new JLabel();
        pikachu_pos.setBounds(50,100,350,50);

        calamardo_pos = new JLabel();
        calamardo_pos.setBounds(50,150,350,50);

        botonIniciarCarrera = new JButton("Iniciar carrera");
        botonIniciarCarrera.setBounds(150, 205, 150, 50);

        // Se hace funcionar al codigo
        botonIniciarCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hilo tgoku = new Hilo("Goku",goku,goku_pos);
                Hilo tpikachu = new Hilo("Pikachu", pikachu,pikachu_pos);
                Hilo tcalamardo = new Hilo("Calamardo", calamardo, calamardo_pos);
            }
        });


        panel.add(goku);
        panel.add(goku_pos);
        panel.add(pikachu);
        panel.add(pikachu_pos);
        panel.add(calamardo);
        panel.add(calamardo_pos);
        panel.add(botonIniciarCarrera);

        add(panel);
        setVisible(true);




    }
}