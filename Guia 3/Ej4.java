public class CuentaBancaria {
    private int saldo;

    public void depositar(int cantidad) {
        saldo += cantidad;
    }

    public void retirar(int cantidad) {
        saldo -= cantidad;
    }

    public int obtenerSaldo() {
        return saldo;
    }
}

public class CajeroAutomatico {
    private CuentaBancaria cuenta;

    public void retirarDinero(int cantidad) {
        if (cuenta.obtenerSaldo() >= cantidad) {
            cuenta.retirar(cantidad);
            System.out.println(cantidad + " retirados exitosamente.");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
}

//System.out  viola principio de dependencias implícitas  dependes implícitamente del objeto out que no estas recibiendo por parametro


//retirar dinero deberia ser parte de cuentaBancaria --> SRP


//El principio violado en el ejemplo es el principio Tell Don't Ask (TDA), ya que la clase CajeroAutomatico está preguntando por el saldo de la cuenta (cuenta.obtenerSaldo()) para luego decidir si es posible realizar una retirada de dinero. Esto viola el principio TDA, ya que el objeto CajeroAutomatico debería "decirle" a la cuenta que retire la cantidad especificada en lugar de preguntarle por su saldo y luego decidir si retirar.
//
//Para solucionar esto, podemos mover la lógica de verificación de saldo a la clase CuentaBancaria:


public class CuentaBancaria {
    private int saldo;

    public void depositar(int cantidad) {
        saldo += cantidad;
    }

    public boolean retirar(int cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
}

public class CajeroAutomatico {
    private CuentaBancaria cuenta;

    public void retirarDinero(int cantidad) {
        boolean ok = cuenta.retirar(cantidad);
        if (ok) {
            System.out.println(cantidad + " retirados exitosamente.");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
}
