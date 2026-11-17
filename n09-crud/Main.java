int leerEntero(String etiqueta) {
    return Integer.parseInt(IO.readln(etiqueta + " › "));
}

void main() {
    Agenda agenda = new Agenda();
    agenda.crear("Familia Rojas", 4, "19:00");
    agenda.crear("Sofía", 2, "18:30");

    while (true) {
        IO.println("\n[1] Crear [2] Listar (ordenadas por hora) [3] Buscar [4] Cambiar hora [5] Cancelar [6] Por hora [0] Salir");
        String op = IO.readln("Opción › ");
        try {
            switch (op) {
                case "1" -> {
                    String cliente = IO.readln("Cliente › ");
                    int personas = leerEntero("Personas (1-8)");
                    String hora = IO.readln("Hora (ej. 18:30) › ");
                    IO.println("Creada: " + agenda.crear(cliente, personas, hora));
                }
                case "2" -> {
                    var lista = agenda.listarOrdenadasPorHora();
                    if (lista.isEmpty()) IO.println("(sin reservas)");
                    for (Reserva r : lista) IO.println(r);
                }
                case "3" -> {
                    int id = leerEntero("Id");
                    var opt = agenda.buscar(id);
                    IO.println(opt.isPresent() ? opt.get() : "No existe la reserva #" + id);
                }
                case "4" -> {
                    int id = leerEntero("Id");
                    String nuevaHora = IO.readln("Nueva hora › ");
                    IO.println(agenda.cambiarHora(id, nuevaHora) ? "Hora actualizada" : "No existe la reserva #" + id);
                }
                case "5" -> {
                    int id = leerEntero("Id");
                    IO.println(agenda.cancelar(id) ? "Reserva cancelada" : "No existe la reserva #" + id);
                }
                case "6" -> {
                    String hora = IO.readln("Hora a consultar › ");
                    var lista = agenda.deLaHora(hora);
                    if (lista.isEmpty()) IO.println("(sin reservas a esa hora)");
                    for (Reserva r : lista) IO.println(r);
                }
                case "0" -> {
                    IO.println("¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {
            IO.println("Error: ingresa un número entero válido.");
        } catch (IllegalArgumentException e) {
            IO.println("Error de validación: " + e.getMessage());
        }
    }
}
