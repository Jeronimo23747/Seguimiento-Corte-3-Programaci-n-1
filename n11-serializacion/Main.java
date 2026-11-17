import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

int leerEntero(String etiqueta) {
    return Integer.parseInt(IO.readln(etiqueta + " › "));
}

void main() {
    var archivo = new ArchivoReservas(Path.of("reservas.ser"));
    List<Reserva> iniciales = List.of();
    try {
        iniciales = archivo.cargar();
        IO.println("Reservas cargadas: " + iniciales.size());
    } catch (InvalidClassException e) {
        IO.println("Archivo rechazado por el filtro de seguridad: " + e.getMessage());
    } catch (InvalidObjectException e) {
        IO.println("Archivo alterado (datos inválidos): " + e.getMessage());
    } catch (IOException | ClassNotFoundException e) {
        IO.println("No se pudo leer el archivo: " + e.getMessage());
    }

    Agenda agenda = new Agenda(iniciales);

    while (true) {
        IO.println("\n[1] Crear [2] Listar [3] Buscar [4] Cambiar hora [5] Cancelar [6] Exportar CSV [7] Probar filtro [0] Guardar y salir");
        String op = IO.readln("Opción › ");
        try {
            switch (op) {
                case "1" -> {
                    String cliente = IO.readln("Cliente › ");
                    int personas = leerEntero("Personas (1-8)");
                    String hora = IO.readln("Hora › ");
                    IO.println("Creada: " + agenda.crear(cliente, personas, hora));
                }
                case "2" -> {
                    var lista = agenda.listar();
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
                    IO.println(agenda.cambiarHora(id, nuevaHora) ? "Actualizada" : "No existe #" + id);
                }
                case "5" -> {
                    int id = leerEntero("Id");
                    IO.println(agenda.cancelar(id) ? "Cancelada" : "No existe #" + id);
                }
                case "6" -> {
                    Path csv = Path.of("reservas.csv");
                    archivo.exportarCsv(agenda.listar(), csv);
                    IO.println("Exportado a " + csv + " (" + Files.size(csv) + " bytes)");
                }
                case "7" -> {
                    Path sospechoso = Path.of("sospechoso.ser");
                    try (var out = new ObjectOutputStream(Files.newOutputStream(sospechoso))) {
                        out.writeObject(new HashMap<String, String>());
                    }
                    try {
                        new ArchivoReservas(sospechoso).cargar();
                    } catch (InvalidClassException e) {
                        IO.println("Filtro funcionó -> InvalidClassException: " + e.getMessage());
                    } finally {
                        Files.deleteIfExists(sospechoso);
                    }
                }
                case "0" -> {
                    archivo.guardar(agenda.listar());
                    IO.println("Reservas guardadas en reservas.ser. ¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {
            IO.println("Error: ingresa un número entero válido.");
        } catch (IllegalArgumentException e) {
            IO.println("Validación: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            IO.println("Error de archivo: " + e.getMessage());
        }
    }
}
