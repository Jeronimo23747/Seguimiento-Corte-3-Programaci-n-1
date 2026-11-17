void main() {
    Barista martin = new Barista();
    martin.nombre = "Martín";
    martin.turno = "mañana";

    Barista ana = new Barista();
    ana.nombre = "Ana";
    ana.turno = "tarde";

    for (int i = 0; i < 3; i++) {
        martin.preparar("Latte");
    }

    for (int i = 0; i < 21; i++) {
        ana.preparar("Capuchino");
    }

    // Caso límite exacto: 20 bebidas
    Barista julian = new Barista();
    julian.nombre = "Julián";
    julian.turno = "noche";
    julian.bebidas = 20;

    martin.recibirPropina(5000);
    martin.recibirPropina(-1000); // debe ignorarse

    IO.println(martin.resumen() + " · ¿Pausa? " + martin.merecePausa() + " · Propinas: $" + martin.propinas);
    IO.println(ana.resumen() + " · ¿Pausa? " + ana.merecePausa());
    IO.println(julian.resumen() + " · ¿Pausa? " + julian.merecePausa());
}
