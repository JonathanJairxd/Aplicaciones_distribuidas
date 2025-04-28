package hilos.clase;

public class ProcesoB extends Thread{
    private int n;

    public ProcesoB(int n){
        this.n = n;
    }

    public void contar(int n){
        for (int i = 1; i < n; i++){
            System.out.println("Iteracción N.- "+ i);
        }
    }

    @Override
    public void run() {
        /*for (int i = 1; i < n; i++){
            System.out.println("Iteracción N.- "+ i);
            try {
                sleep(2000); //pausa la ejecucion del hilo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
        contar(n);
    }
}
