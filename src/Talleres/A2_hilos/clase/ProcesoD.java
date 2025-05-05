package Talleres.A2_hilos.clase;

public class ProcesoD implements Runnable{
    private int n;

    public ProcesoD(int numero){
        n = numero;
    }

    public void dibujar(int n){
        for (int i = 0; i < n ; i++) {
            System.out.println("************************");
        }
    }

    @Override
    public void run() {
        dibujar(n);

    }
}
