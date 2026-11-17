import java.util.List;

public record Recibo(int numero, List<LineaRecibo> lineas, int descuentoAplicado, int totalFinal) {
    public Recibo {
        lineas = List.copyOf(lineas);
        if (totalFinal < 0) {
            throw new IllegalArgumentException("El total final no puede ser negativo");
        }
    }
}
