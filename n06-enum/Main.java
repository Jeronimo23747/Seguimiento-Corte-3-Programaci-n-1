import java.util.EnumMap;
import java.util.Map;

Map<EstadoMesa, Integer> contar(EstadoMesa[] mesas) {
    Map<EstadoMesa, Integer> conteo = new EnumMap<>(EstadoMesa.class);
    for (EstadoMesa e : EstadoMesa.values()) {
        conteo.put(e, 0);
    }
    for (EstadoMesa m : mesas) {
        conteo.put(m, conteo.get(m) + 1);
    }
    return conteo;
}

void main() {
    EstadoMesa[] mesas = {
            EstadoMesa.LIBRE,
            EstadoMesa.OCUPADA,
            EstadoMesa.POR_LIMPIAR,
            EstadoMesa.RESERVADA,
            EstadoMesa.LIBRE,
            EstadoMesa.OCUPADA,
            EstadoMesa.LIBRE,
            EstadoMesa.POR_LIMPIAR
    };

    IO.println("Estado inicial: " + contar(mesas));
    IO.println("¿Mesa 0 disponible? " + mesas[0].disponible() + " (" + mesas[0].aviso() + ")");

    for (int i = 0; i < mesas.length; i++) {
        mesas[i] = mesas[i].siguiente();
    }

    IO.println("Después de avanzar un paso: " + contar(mesas));
}
