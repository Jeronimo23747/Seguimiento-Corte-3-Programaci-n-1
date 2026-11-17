import java.util.ArrayList;
import java.util.List;

void main() {
    var latte = new ItemMenu("Latte", Categoria.CALIENTE, 9500);
    var tinto = new ItemMenu("Tinto", Categoria.CALIENTE, 3500);
    var brownie = new ItemMenu("Brownie", Categoria.POSTRE, 7000);

    var lista = new ArrayList<>(List.of(latte, tinto, brownie));
    var menu = new MenuDelDia("2026-11-16", lista);

    // Subir 10% el precio de un ítem sin mutar el original
    var latteSubido = latte.conPrecio(latte.precio() * 110 / 100);
    IO.println("Original: " + latte);
    IO.println("Nuevo:    " + latteSubido);
    IO.println("¿El original sigue igual? " + latte.equals(new ItemMenu("Latte", Categoria.CALIENTE, 9500)));

    IO.println("Promedio del menú (" + menu.fecha() + "): $" + menu.promedioPrecio());

    // Recorrer con patrón de record para imprimir solo una categoría
    IO.println("Bebidas calientes:");
    for (ItemMenu item : menu.items()) {
        if (item instanceof ItemMenu(var n, var c, var p) && c == Categoria.CALIENTE) {
            IO.println(" - " + n + ": $" + p);
        }
    }

    // Extra +10 XP: intentar modificar la lista inmutable del record
    try {
        menu.items().add(new ItemMenu("Galleta", Categoria.PANADERIA, 3000));
    } catch (UnsupportedOperationException e) {
        IO.println("Inmutabilidad protegida: UnsupportedOperationException al intentar agregar a menu.items()");
    }
}
