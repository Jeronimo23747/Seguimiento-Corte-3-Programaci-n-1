import java.util.ArrayList;
import java.util.List;

public class Caja {
    private final Notificador notificador;
    private int saldo;
    private int numeroRecibo = 1001;

    public Caja(Notificador notificador) {
        this.notificador = notificador;
    }

    public int getSaldo() { return saldo; }

    public Recibo cobrar(Pedido pedido, Descuento descuento, String destino) {
        int bruto = pedido.total();
        int finalTotal = descuento.aplicar(bruto);
        if (finalTotal < 0) {
            throw new IllegalArgumentException("Total inválido");
        }
        saldo += finalTotal;

        List<LineaRecibo> lineasRecibo = new ArrayList<>();
        for (LineaPedido lp : pedido.getLineas()) {
            lineasRecibo.add(lp.aLineaRecibo());
        }

        Recibo recibo = new Recibo(numeroRecibo++, lineasRecibo, bruto - finalTotal, finalTotal);
        notificador.enviar(destino, "Recibo #" + recibo.numero() + " · Total $" + finalTotal);
        return recibo;
    }
}
