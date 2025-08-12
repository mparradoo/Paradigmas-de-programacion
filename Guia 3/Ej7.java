public class Rectangulo {
    private int ancho;
    private int alto;

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int calcularArea() {
        return ancho * alto;
    }
}

public class Cuadrado extends Rectangulo {
    public Cuadrado(int lado) {
        super(lado, lado);
    }

    @Override
    public void setAncho(int ancho) {
        super.setAncho(ancho);
        super.setAlto(ancho);
    }

    @Override
    public void setAlto(int alto) {
        super.setAncho(alto);
        super.setAlto(alto);
    }
}



//la clase Cuadrado no aporta nada, un rectangulo puede ser un cuadrado.

//YAGNI, por lo dicho arriba tambien

// PolA --> Si la clase no fuese Cuadrado, no se podria setear ancho y alto al mismo tiempo, en este caso si pero solamente porque es un cuadrado. Seria mejor un set_lado

//En este ejemplo, la clase Cuadrado hereda de la clase Rectangulo y sobreescribe los métodos setAncho() y getAncho(). El problema es que esto viola el Principio de Sustitución de Liskov (LSP) porque el Cuadrado ya no se comporta como un Rectangulo.
//
//Por ejemplo, una parte del programa que manipula un Rectangulo podría recibir un Cuadrado. Al invocar el método setAlto() se estaría alterando inadvertidamente el ancho.
//
//Una posible solución es crear una clase Figura abstracta y dos subclases Rectangulo y Cuadrado que implementen la operación calcularArea(). De esta manera, se evita la dependencia entre Cuadrado y Rectangulo y se pueden mantener las propiedades únicas de cada figura.