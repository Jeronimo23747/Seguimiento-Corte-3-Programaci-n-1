import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repositorio<T extends Identificable> {
    private final List<T> items = new ArrayList<>();

    public void guardar(T item) {
        eliminar(item.id());
        items.add(item);
    }

    public List<T> listar() {
        return List.copyOf(items);
    }

    public Optional<T> buscar(int id) {
        for (T item : items) {
            if (item.id() == id) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public boolean eliminar(int id) {
        return items.removeIf(item -> item.id() == id);
    }

    public int cantidad() {
        return items.size();
    }
}
