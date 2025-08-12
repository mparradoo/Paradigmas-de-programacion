class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public void guardar() {
        // código para guardar el usuario en la base de datos
    }

    public void enviarEmailBianvenida() {
        // código para enviar un email de bienvenida al usuario
    }

    public void cambiarPassword(String nuevoPassword) {
        // código para cambiar la contraseña
    }

    public void delete() {
        // código para eliminar el usuario de la base de datos
    }
}

//SOC o SRP  --> La clase Usuario deberia tener una unica responsabilidad. Como un usuario se agrega a si mismo a una base de datos?Deberia haber una clase base de datos que se encargue de eso

// La clase Usuario solo contiene los datos de usuario y métodos para
// acceder y modificar dichos datos.
class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    // [...] métodos para acceder y modificar los datos del usuario
}

// La clase UsuarioDAO se encarga de la gestión de la base de datos.
// (Nota: DAO significa Data Access Object)
class UsuarioDAO {
    public void guardar(Usuario usuario) {
        // código para guardar el usuario en la base de datos
    }

    public void delete(Usuario usuario) {
        // código para eliminar el usuario de la base de datos
    }
}

// La clase EmailService se encarga del envío de correos electrónicos
class ServicioEmail {
    public void enviarEmailBianvenida(Usuario usuario) {
        // código para enviar un email de bienvenida al usuario
    }
}


//El código presentado viola el principio de responsabilidad única (SRP) ya que la clase Usuario tiene responsabilidades que van más allá de la gestión de los datos de usuario. También se viola el principio SoC (Separation of Concerns).