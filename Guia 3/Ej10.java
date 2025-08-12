class Usuario {
    private String nombre;
    private String email;
    private BaseDeDatos db;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.db = new BaseDeDatos();
    }

    public void guardar() {
        this.db.guardar(this);
    }
}

class BaseDeDatos {
    public static void guadar(Usuario user) {
        // código para guardar el usuario en la base de datos
    }
}

//DIP  Modulos de alto nivel no deberían depender de modulos de bajo nivel. Detalles dependen de abstracciones
// La clase Usuario depende de Base de datos

//La clase Usuario viola el principio DIP (Dependency Inversion) ya que depende de una implementación concreta de la clase BaseDeDatos que se crea en el constructor. Si quisiéramos cambiar la forma en que se guardan los datos tendríamos que modificar la clase Usuario.
//
//También viola el EDP (Explicit Dependencies Principle) ya que Usuario depende implícitamente de una clase concreta BaseDeDatos.
//
//Una posible solución es que el Usuario reciba una instancia de una interfaz BaseDeDatos. De esta manera se pueden implementar diferentes estrategias para guardar en la base de datos sin modificar la clase Usuario.


class Usuario {
    private String name;
    private String email;

    public Usuario(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void guardar(BaseDeDatos db) {
        db.guardar(this);
    }
}

interface BaseDeDatos {
    public void guardar(Usuario usuario);
}

