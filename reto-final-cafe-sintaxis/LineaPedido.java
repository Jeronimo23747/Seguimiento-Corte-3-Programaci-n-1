public class LineaPedido {
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad mínima es 1");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public int subtotal() {
        return producto.precioFinal() * cantidad;
    }

    public LineaRecibo aLineaRecibo() {
        return new LineaRecibo(producto.getNombre(), producto.precioFinal(), cantidad);
    }

    public String texto() {
        return cantidad + " × " + producto.getNombre() + " = $" + subtotal();
    }
}
