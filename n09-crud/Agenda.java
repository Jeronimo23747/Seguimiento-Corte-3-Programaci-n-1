import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private final List<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    // C · crear
    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId++, cliente, personas, hora);
        reservas.add(r);
        return r;
    }

    // R · listar (copia inmutable)
    public List<Reserva> listar() {
        return List.copyOf(reservas);
    }

    // Extra +10 XP: listar ordenado por hora con sort
    public List<Reserva> listarOrdenadasPorHora() {
        List<Reserva> copia = new ArrayList<>(reservas);
        copia.sort(Comparator.comparing(Reserva::getHora));
        return List.copyOf(copia);
    }

    // R · buscar por id
    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    // R · filtrar por hora
    public List<Reserva> deLaHora(String hora) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getHora().equals(hora)) {
                resultado.add(r);
            }
        }
        return List.copyOf(resultado);
    }

    // U · cambiarHora
    public boolean cambiarHora(int id, String nuevaHora) {
        Optional<Reserva> encontrada = buscar(id);
        if (encontrada.isEmpty()) {
            return false;
        }
        encontrada.get().setHora(nuevaHora);
        return true;
    }

    // D · cancelar
    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }
}
