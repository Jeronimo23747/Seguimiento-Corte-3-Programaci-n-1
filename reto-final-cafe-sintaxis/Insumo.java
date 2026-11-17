import java.io.Serializable;

public record Insumo(int id, String nombre, int cantidad) implements Identificable, Serializable {
    public Insumo {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del insumo no puede estar vacío");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa: " + cantidad);
        }
    }

    public Insumo conCantidad(int nuevaCantidad) {
        return new Insumo(id, nombre, nuevaCantidad);
    }
}
