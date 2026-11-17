public class Combo {
    private final String bebida;
    private final String postre;
    private final int precio;

    public Combo(String bebida, String postre, int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0: " + precio);
        }
        this.bebida = bebida;
        this.postre = postre;
        this.precio = precio;
    }

    public Combo(String bebida, int precio) {
        if (bebida == null || bebida.isBlank()) { // Prólogo JEP 513 (Java 25)
            throw new IllegalArgumentException("La bebida no puede estar vacía");
        }
        this(bebida, "sin postre", precio);
    }

    public int precioFinal() {
        return precio;
    }

    public int precioFinal(int propinaPct) {
        int base = precioFinal();
        return base + base * propinaPct / 100;
    }

    public String descripcion() {
        return bebida + " + " + postre + " ($" + precio + ")";
    }
}
