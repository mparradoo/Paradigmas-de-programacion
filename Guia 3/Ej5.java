public class Empleado {
    private String nombre;
    private String apellido;
    private int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}

//YAGNI --> getNombreCompleto no va a ser necesario
//DRY --> Se devuelve nombre apellido y dsp nombre y apellido los dos juntos

//En el ejemplo se viola el Principio de Mínimo Compromiso (POLC), ya que el método getNombreCompleto() no es parte de la interfaz mínima necesaria para operar con un Empleado, ya que los métodos getNombre() getApellido() proporcionan toda la información necesaria para formar el nombre completo.
//
//Una solución es simplemente eliminar el método getNombreCompleto() y mover esa lógica a otra clase.