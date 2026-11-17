import java.util.ArrayList;
import java.util.List;

public class DestinoMemoria implements Destino {
    private final List<String> enviados = new ArrayList<>();

    @Override
    public void enviar(String texto) {
        enviados.add(texto);
    }

    public List<String> enviados() {
        return List.copyOf(enviados);
    }
}
