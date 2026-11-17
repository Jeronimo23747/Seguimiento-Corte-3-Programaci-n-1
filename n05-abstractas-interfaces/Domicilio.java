public class Domicilio extends Entrega implements Rastreable, Prioritaria {
    private final int km;
    private String estadoActual = "en camino";

    public Domicilio(int pedidoId, int km) {
        super(pedidoId);
        this.km = km;
    }

    @Override
    public int costo() {
        return 2000 + 800 * km;
    }

    @Override
    public String estado() {
        return estadoActual;
    }

    public void avanzar() {
        estadoActual = "entregado";
    }

    @Override
    public boolean esUrgente() {
        return km >= 5;
    }
}
