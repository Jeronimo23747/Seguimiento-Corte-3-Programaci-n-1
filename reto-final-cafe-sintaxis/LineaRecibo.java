public record LineaRecibo(String producto, int precio, int cantidad) {
    public LineaRecibo {
        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException("Producto vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad mínima: 1");
        }
    }

    public int subtotal() {
        return precio * cantidad;
    }
}
