interface Vehiculo {
    void arrancarMotor();
    void pararMotor();
    void acelerar();
    void frenar();
    void cambiarMarcha();
    void encenderFaros();
    void apagarFaros();
    void encenderRadio();
    void apagarRadio();
}

class Coche implements Vehiculo {
    public void arrancarMotor() {
        // código para arrancar el motor
    }

    public void pararMotor() {
        // código para parar el motor
    }

    public void acelerar() {
        // código para acelerar el coche
    }

    public void frenar() {
        // código para aplicar los frenos
    }

    public void cambiarMarcha() {
        // código para cambiar las marchas
    }

    public void encenderFaros() {
        // código para encender los faros
    }

    public void apagarFaros() {
        // código para apagar los faros
    }

    public void encenderRadio() {
        // código para encender la radio
    }

    public void apagarRadio() {
        // código para apagar la radio
    }
}

class Bicicleta implements Vehiculo {
    public void arrancarMotor() {
        // lanzar una excepción, ya que las bicicletas no tienen motor
    }

    public void pararMotor() {
        // lanzar una excepción, ya que las bicicletas no tienen motor
    }

    public void acelerar() {
        // código para acelerar la bicicleta
    }

    public void frenar() {
        // código para aplicar los frenos
    }

    public void cambiarMarcha() {
        // código para cambiar las marchas
    }

    public void encenderFaros() {
        // código para encender los faros
    }

    public void apagarFaros() {
        // código para apagar los faros
    }

    public void encenderRadio() {
        // lanzar una excepción, ya que las bicicletas no tienen radio
    }

    public void apagarRadio() {
        // lanzar una excepción, ya que las bicicletas no tienen radio
    }
}


//PolC --> Bicicleta tiene arrancar_Motor
//LSP --> Una bici no puede sustituir a Vehiculo. A este vehiculo ya que tiene arrancarMotor... entre otras.
//ISP --> Tengo todo agrupado en un interfaz cuando seria mejor que este separado

//La interfaz Vehiculo viola el principio ISP (Interface Segregation), ya que expone métodos que no son relevantes para todas las imlementaciones.
//
//Una solución posible es separar la interfaz:

interface Vehiculo {
    void acelerar();
    void frenar();
}

interface VehiculoConCambios {
    void cambiarMarcha();
}

interface VehiculoConFaros {
    void encenderFaros();
    void apagarFaros();
}

interface VehiculoMotorizado {
    void arrancarMotor();
    void pararMotor();
}

interface VehiculoConRadio {
    void encenderRadio();
    void apagarRadio();
}

class Coche implements Vehiculo, VehiculoConCambios, VehiculoConFaros, VehiculoMotorizado, VehiculoConRadio {
    // ...
}

class Bicicleta implements Vehiculo, VehiculoConCambios, VehiculoConFaros {
    // ...
}