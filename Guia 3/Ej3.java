public class Rectangulo {
    private int ancho;
    private int alto;

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getArea() {
        return ancho * alto;
    }
}

public class Cuboide extends Rectangulo {
    private int profundidad;

    public Cuboid(int ancho, int alto, int profundidad) {
        super(ancho, alto);
        this.profundidad = profundidad;
    }

    public int getVolumen() {
        return ancho * alto * profundidad;
    }
}


//Liskov podria ir tambien

//En el ejemplo se viola el principio DRY, ya que en el método getVolumen() se hace la cuenta ancho * alto que corresponde al área del rectángulo y está repetida en getArea().
//
//Una solución es reemplazar getVolumen() por:
//
//    public int getVolumen() {
//        return getArea() * profundidad;
//    }