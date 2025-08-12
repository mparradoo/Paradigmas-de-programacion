public class CarritoDeCompras {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}

public class ServicioWeb {
    public agregarAlCarrito(CarritoDeCompras carrito, Item item) {
        carrito.getItems().add(item);
    }
}

//PolK  porque estoy metiéndome con un objeto que no corresponde. ServicioWeb intenta agregar ítems.

//En el ejemplo se viola el principio de mínimo conocimiento (POLK), ya que el método getItems() devuelve la instancia interna de la lista items. El que invocó al método podría entonces agregar, quitar o modificar items de la lista, cambiando inadvertidamente el estado del CarritoDeCompras. Por otro lado, el método agregarAlCarrito del ServicioWeb está violando la Ley de Demeter al invocar un método de un objeto extraño.

