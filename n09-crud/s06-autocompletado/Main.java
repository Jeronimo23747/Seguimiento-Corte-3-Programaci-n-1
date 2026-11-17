import java.util.ArrayList;
import java.util.List;

void main() {
    List<String> espera = new ArrayList<>();
    espera.add("Rojas (4)");         // C
    espera.add("Gómez (2)");
    espera.add("Pérez (3)");
    IO.println("En espera: " + espera.size()); // R
    IO.println("Sigue: " + espera.getFirst());
    espera.set(1, "Gómez (5)");       // U
    espera.removeIf(n -> n.startsWith("Rojas")); // D
    IO.println(espera);
    IO.println("¿Pérez? " + espera.contains("Pérez (3)"));
}
