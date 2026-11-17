import java.util.ArrayList;
import java.util.List;

public class Historial<T extends Comparable<T>> {
    private final int capacidad;
    private final List<T> elementos = new ArrayList<>();

    public Historial(int capacidad) {
        if (capacidad < 1) {
            throw new IllegalArgumentException("La capacidad debe ser al menos 1");
        }
        this.capacidad = capacidad;
    }

    public void agregar(T item) {
        if (elementos.size() == capacidad) {
            elementos.removeFirst();
        }
        elementos.add(item);
    }

    public T masReciente() {
        return elementos.getLast();
    }

    public List<T> todos() {
        return List.copyOf(elementos);
    }

    // Extra +10 XP: acotado a Comparable<T>
    public T mayor() {
        T mejor = elementos.getFirst();
        for (T item : elementos) {
            if (item.compareTo(mejor) > 0) {
                mejor = item;
            }
        }
        return mejor;
    }
}
