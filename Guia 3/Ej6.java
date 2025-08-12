public class Producto {
    private String nombre;
    private double price;
    private String tipo;

    public Producto(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public double calcularPrecio() {
        if (tipo.equals("electrónica")) {
            return precio * 1.1;  // agregar impuesto de 10%
        } else if (tipo.equals("ropa")) {
            return precio * 1.2;  // agregar impuesto de 20%
        } else {
            return precio;
        }
    }
}


//SoC --> la clase producto esta haciendo mas de una cosa. El producto no tiene que ver con los impuestos
//SRP --> casi lo mismo
// OCP --> deberia ser abierto a la extension no a la modificacion
//tell dont ask tambien podria ser por tantos if y else

//La clase Producto viola el principio OCP (Open-Closed Principle), ya que si queremos añadir un nuevo tipo de producto (por ejemplo "limpieza") nos vemos obligados a modificar el código de la clase Producto.
//
//Una posible solución sería crear una clase para cada tipo de producto y sobreescribir el método calcularPrecio:



public abstract class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double calcularPrecio();
}

public class ProductoElectronico extends Producto {
    public ProductoElectronico(String nombre, double precio) {
        super(nombre, precio);
    }

    public double calcularPrecio() {
        return super.calcularPrecio() * 1.1;  // add 10% tax for electronics
    }
}

public class ProductoRopa extends Producto {
    public ProductoRopa(String nombre, double precio) {
        super(nombre, precio);
    }

    public double calcularPrecio() {
        return super.calcularPrecio() * 1.2;  // add 20% tax for clothing
    }
}