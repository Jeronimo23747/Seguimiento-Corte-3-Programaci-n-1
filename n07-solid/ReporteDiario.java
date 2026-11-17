import java.util.List;

public class ReporteDiario {
    private final Totales totales = new Totales();
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Formato formato, Destino destino) {
        this.formato = formato;
        this.destino = destino;
    }

    public void generar(List<Integer> ventas) {
        int total = totales.sumar(ventas);
        int cantidad = totales.cantidad(ventas);
        String salida = formato.dar(total, cantidad);
        destino.enviar(salida);
    }
}
