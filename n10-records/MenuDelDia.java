import java.util.List;

public record MenuDelDia(String fecha, List<ItemMenu> items) {
    public MenuDelDia {
        items = List.copyOf(items);
    }

    public int promedioPrecio() {
        if (items.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (ItemMenu item : items) {
            total += item.precio();
        }
        return total / items.size();
    }
}
