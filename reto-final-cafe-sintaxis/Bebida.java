public class Bebida extends Producto implements Personalizable {
    private final Tamano tamano;

    public Bebida(int id, String nombre, int precioBase, Categoria categoria, Tamano tamano) {
        super(id, nombre, precioBase, categoria);
        this.tamano = tamano;
    }

    // Constructor corto con prólogo JEP 513 (Java 25)
    public Bebida(int id, String nombre, int precioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Bebida sin nombre");
        }
        this(id, nombre, precioBase, Categoria.CALIENTE, Tamano.MEDIANO);
    }

    public Tamano getTamano() { return tamano; }

    @Override
    public int precioFinal() {
        return getPrecioBase() + tamano.recargo();
    }

    @Override
    public int minutosPreparacion() {
        return 4;
    }

    @Override
    public int extra(String opcion) {
        return opcion.equals("shot extra") ? 2000 : 1500;
    }

    @Override
    public String ficha() {
        return super.ficha() + " · " + tamano.ml() + " ml";
    }
}
