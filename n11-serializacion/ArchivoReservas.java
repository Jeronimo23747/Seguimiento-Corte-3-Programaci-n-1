import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArchivoReservas {
    private static final String PERMITIDOS = "Reserva;java.util.ArrayList;java.lang.Object;!*";
    private final Path archivo;

    public ArchivoReservas(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Reserva> reservas) throws IOException {
        try (var out = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(reservas));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivo))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Reserva>) in.readObject();
        }
    }

    public void exportarCsv(List<Reserva> reservas, Path csv) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;cliente;personas;hora");
        for (Reserva r : reservas) {
            lineas.add(r.id() + ";" + r.cliente() + ";" + r.personas() + ";" + r.hora());
        }
        Files.write(csv, lineas);
    }
}
