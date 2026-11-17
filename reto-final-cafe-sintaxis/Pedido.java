import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int mesa;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int mesa) {
        if (mesa < 1) {
            throw new IllegalArgumentException("Número de mesa inválido: " + mesa);
        }
        this.mesa = mesa;
    }

    public int getMesa() { return mesa; }

    public void agregar(Producto p, int cantidad) {
        lineas.add(new LineaPedido(p, cantidad));
    }

    public List<LineaPedido> getLineas() {
        return List.copyOf(lineas);
    }

    public int total() {
        int t = 0;
        for (LineaPedido l : lineas) {
            t += l.subtotal();
        }
        return t;
    }
}
