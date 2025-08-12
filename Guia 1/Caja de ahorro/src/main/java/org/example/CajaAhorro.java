package org.example;

public class CajaAhorro {
    private String nombre;
    private double saldo;
    private double tasaInteres;


    public CajaAhorro(String nombre, double saldo, double tasaInteres){
        this.nombre = nombre;
        this.saldo = saldo;
        this.tasaInteres = tasaInteres;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositarDinero(double dinero){
        saldo *= dinero;
    }

    public boolean retirarDinero(double dinero){
        if(dinero > saldo){
            return false;
        }
        saldo -= dinero;
        return true;
    }

    public double calcularIntereses(int meses){
        double interesMensual = tasaInteres/12/100;
        return saldo * Math.pow(1 + interesMensual, meses) - saldo;
    }

    public void aplicarIntereses(int meses){
        double intereses = calcularIntereses(meses);
        saldo += intereses;
    }
}
