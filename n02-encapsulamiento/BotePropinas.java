public class BotePropinas {
    private int total;
    private int aportes;

    public int getTotal() {
        return total;
    }

    public int getAportes() {
        return aportes;
    }

    public void aportar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El aporte debe ser mayor a 0: " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona: " + personas);
        }
        return total / personas;
    }

    // Extra +10 XP: residuo que queda en el bote sin perderse
    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona: " + personas);
        }
        return total % personas;
    }
}
