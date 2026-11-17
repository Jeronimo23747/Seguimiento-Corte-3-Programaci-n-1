public enum EstadoMesa {
    LIBRE("Lista para sentarse"),
    OCUPADA("Con clientes"),
    POR_LIMPIAR("Requiere limpieza"),
    RESERVADA("Reservada para cliente");

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() {
        return aviso;
    }

    public EstadoMesa siguiente() {
        return switch (this) {
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
            case RESERVADA -> OCUPADA;
            case LIBRE -> OCUPADA;
        };
    }

    public boolean disponible() {
        return this == LIBRE;
    }
}
