package Talleres.A2_hilos.clase;

public class ProcesoA extends Thread{
    private String name;

    public ProcesoA(String name){
        this.name= name;
    }
    public void saludar (String name ){
        System.out.println("Hola " + name+ "\n");
    }

    @Override
    public void run() {
        saludar(name);
    }
}
