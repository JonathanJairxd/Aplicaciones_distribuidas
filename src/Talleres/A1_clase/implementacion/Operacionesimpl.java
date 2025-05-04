package Talleres.A1_clase.implementacion;

import Talleres.A1_clase.interfaz.Operaciones;

public class Operacionesimpl implements Operaciones {
    @Override
    public double sumar(double x, double y) {
        return x+y;
    }

    @Override
    public double restar(double x, double y) {
        return x-y;
    }

    @Override
    public double multiplicar(double x, double y) {
        return x*y;
    }

    @Override
    public double dividir(double x, double y) {
        return x/y;
    }
}
