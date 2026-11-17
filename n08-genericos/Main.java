import java.util.List;

<T> int contar(List<T> lista, T buscado) {
    int total = 0;
    for (T item : lista) {
        if (item.equals(buscado)) {
            total++;
        }
    }
    return total;
}

int sumar(List<? extends Number> l) {
    int suma = 0;
    for (Number n : l) {
        suma += n.intValue();
    }
    return suma;
}

void main() {
    var pedidos = new Historial<String>(3);
    pedidos.agregar("Latte");
    pedidos.agregar("Tinto");
    pedidos.agregar("Latte");
    pedidos.agregar("Moka"); // desaloja el primer "Latte"

    IO.println("Últimos pedidos (capacidad 3): " + pedidos.todos());
    IO.println("Más reciente: " + pedidos.masReciente());
    IO.println("Veces 'Latte': " + contar(pedidos.todos(), "Latte"));
    IO.println("Mayor alfabéticamente: " + pedidos.mayor());

    var cobros = new Historial<Integer>(3);
    cobros.agregar(9500);
    cobros.agregar(3500);
    cobros.agregar(10500);
    cobros.agregar(7000); // desaloja 9500

    IO.println("Últimos cobros: " + cobros.todos());
    IO.println("Suma de últimos cobros: $" + sumar(cobros.todos()));
    IO.println("Cobro mayor: $" + cobros.mayor());
}
