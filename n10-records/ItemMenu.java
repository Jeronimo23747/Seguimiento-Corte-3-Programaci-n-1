public record ItemMenu(String nombre, Categoria categoria, int precio) {
    public ItemMenu {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo: " + precio);
        }
    }

    public ItemMenu conPrecio(int nuevo) {
        return new ItemMenu(nombre, categoria, nuevo);
    }
}
