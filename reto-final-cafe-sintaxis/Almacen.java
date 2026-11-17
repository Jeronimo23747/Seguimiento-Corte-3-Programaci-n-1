import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static final String PERMITIDOS = "Insumo;java.util.ArrayList;java.lang.Object;!*";
    private final Path archivo;

    public Almacen(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Insumo> insumos) throws IOException {
        try (var out = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(insumos));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Insumo> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivo))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Insumo>) in.readObject();
        }
    }

    public void exportarCsv(List<Insumo> insumos, Path csv) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;nombre;cantidad");
        for (Insumo i : insumos) {
            lineas.add(i.id() + ";" + i.nombre() + ";" + i.cantidad());
        }
        Files.write(csv, lineas);
    }
}
