import java.util.List;

void main() {
    Domicilio dom = new Domicilio(103, 5);
    List<Entrega> entregas = List.of(
            new EnMesa(101),
            new ParaLlevar(102),
            dom
    );

    for (Entrega e : entregas) {
        IO.println(e.resumen());
        if (e instanceof Rastreable r) {
            IO.println("  Estado: " + r.estado() + " (¿entregado? " + r.entregado() + ")");
        }
        if (e instanceof Prioritaria p && p.esUrgente()) {
            IO.println("  ¡Entrega prioritaria!");
        }
    }

    dom.avanzar();
    IO.println("Tras avanzar domicilio #103: " + dom.estado() + " (¿entregado? " + dom.entregado() + ")");
}
