import java.io.Serializable;

public record Reserva(int id, String cliente, int personas, String hora) implements Serializable {
    public Reserva {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Las reservas son de 1 a 8 personas (recibido: " + personas + ")");
        }
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("La hora no puede estar vacía");
        }
    }

    public Reserva conHora(String nuevaHora) {
        return new Reserva(id, cliente, personas, nuevaHora);
    }

    @Override
    public String toString() {
        return "#" + id + " " + cliente + " · " + personas + " pers. · " + hora;
    }
}
