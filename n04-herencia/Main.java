void main() {
    Turno turno = new Turno();
    turno.agregar(new Barista("Martín", 50000, 35));
    turno.agregar(new Mesero("Sofía", 45000, 12000));

    // Casos límite con 0 bebidas y 0 propinas
    turno.agregar(new Barista("Lucas", 50000, 0));
    turno.agregar(new Mesero("Camila", 45000, 0));

    turno.imprimirNomina();
}
