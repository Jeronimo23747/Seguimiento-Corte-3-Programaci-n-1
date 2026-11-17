public interface Rastreable {
    String estado();

    default boolean entregado() {
        return estado().equals("entregado");
    }
}
