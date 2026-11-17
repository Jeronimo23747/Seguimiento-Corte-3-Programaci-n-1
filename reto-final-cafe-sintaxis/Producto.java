public abstract class Producto implements Identificable {
    private final int id;
    private final String nombre;
    private final int precioBase;
    private final Categoria categoria;

    protected Producto(int id, String nombre, int precioBase, Categoria categoria) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser positivo: " + precioBase);
        }
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecioBase() { return precioBase; }
    public Categoria getCategoria() { return categoria; }

    public abstract int precioFinal();
    public abstract int minutosPreparacion();

    public String ficha() {
        return "#" + id + " " + nombre + " (" + categoria.etiqueta() + ") $" + precioFinal()
                + " · " + minutosPreparacion() + " min";
    }
}
