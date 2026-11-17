void main() {
    BotePropinas bote = new BotePropinas();
    bote.aportar(2000);
    bote.aportar(5000);
    bote.aportar(3500);

    try {
        bote.aportar(-100);
    } catch (IllegalArgumentException e) {
        IO.println("Aporte rechazado: " + e.getMessage());
    }

    try {
        bote.repartir(0);
    } catch (IllegalArgumentException e) {
        IO.println("Reparto rechazado: " + e.getMessage());
    }

    IO.println("Total en bote: $" + bote.getTotal());
    IO.println("Aportes realizados: " + bote.getAportes());
    IO.println("Por persona (3): $" + bote.repartir(3));
    IO.println("Sobrante en el bote: $" + bote.sobrante(3));
}
