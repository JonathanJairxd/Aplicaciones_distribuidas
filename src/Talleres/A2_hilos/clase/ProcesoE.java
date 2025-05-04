package Talleres.A2_hilos.clase;

public class ProcesoE implements Runnable {
    private String texto;

    public ProcesoE(String texto){
        this.texto = texto;
    }

    public void mensaje(String texto){



    }

    @Override
    public void run() {
        mensaje(texto);
    }
}
