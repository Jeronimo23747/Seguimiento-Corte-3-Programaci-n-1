import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

void main() throws Exception {
    IO.println("=== CAFÉ SINTAXIS 1.0 ===");

    // 1. Repositorio genérico de menú (N01, N04, N05, N06, N08, N09)
    var menu = new Repositorio<Producto>();
    var latte = new Bebida(1, "Latte", 8000, Categoria.CALIENTE, Tamano.GRANDE);
    var tinto = new Bebida(2, "Tinto", 3500); // constructor corto + prólogo
    var brownie = new Postre(3, "Brownie", 7000, true);

    menu.guardar(latte);
    menu.guardar(tinto);
    menu.guardar(brownie);

    IO.println("\n--- Menú del día ---");
    for (Producto p : menu.listar()) {
        IO.println(p.ficha());
        if (p instanceof Personalizable per) {
            IO.println("  Opciones: " + per.opciones());
        }
    }

    // 2. Pedido y Caja SOLID (N02, N04, N07, N10)
    var pedido = new Pedido(4);
    pedido.agregar(menu.buscar(1).orElseThrow(), 2);
    pedido.agregar(menu.buscar(3).orElseThrow(), 1);

    var caja = new Caja(new NotificadorConsola());
    IO.println("\n--- Cobro en caja ---");
    Recibo recibo = caja.cobrar(pedido, new Porcentaje(10), "300 555 0101");
    IO.println("Recibo inmutable: " + recibo);
    IO.println("Saldo en caja: $" + caja.getSaldo());

    // 3. Bodega con CRUD, Records y Serialización con filtro + CSV (N08, N09, N10, N11)
    var almacen = new Almacen(Path.of("bodega.ser"));
    var inventario = new Repositorio<Insumo>();
    List<Insumo> previos = almacen.cargar();
    if (previos.isEmpty()) {
        inventario.guardar(new Insumo(1, "Leche entera (L)", 20));
        inventario.guardar(new Insumo(2, "Café en grano (kg)", 5));
    } else {
        for (Insumo i : previos) inventario.guardar(i);
    }

    // Actualizar insumo 1
    inventario.buscar(1).ifPresent(leche -> inventario.guardar(leche.conCantidad(leche.cantidad() + 5)));

    almacen.guardar(inventario.listar());
    Path csv = Path.of("bodega.csv");
    almacen.exportarCsv(inventario.listar(), csv);

    IO.println("\n--- Bodega persistida ---");
    IO.println("Cargado desde bodega.ser: " + almacen.cargar());
    IO.println("Tamaño CSV: " + Files.size(csv) + " bytes");
}
