import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private final List<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    public Agenda(List<Reserva> iniciales) {
        for (Reserva r : iniciales) {
            reservas.add(r);
            if (r.id() >= siguienteId) {
                siguienteId = r.id() + 1;
            }
        }
    }

    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId++, cliente, personas, hora);
        reservas.add(r);
        return r;
    }

    public List<Reserva> listar() {
        return List.copyOf(reservas);
    }

    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.id() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public boolean cambiarHora(int id, String nuevaHora) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).id() == id) {
                reservas.set(i, reservas.get(i).conHora(nuevaHora));
                return true;
            }
        }
        return false;
    }

    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.id() == id);
    }
}
