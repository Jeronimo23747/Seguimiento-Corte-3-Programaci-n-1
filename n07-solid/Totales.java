import java.util.List;

// S: Única responsabilidad - calcular totales
public class Totales {
    public int sumar(List<Integer> ventas) {
        int total = 0;
        for (int v : ventas) {
            total += v;
        }
        return total;
    }

    public int cantidad(List<Integer> ventas) {
        return ventas.size();
    }
}
