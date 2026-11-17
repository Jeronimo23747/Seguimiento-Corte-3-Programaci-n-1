void main() {
    Combo c1 = new Combo("Latte", "Brownie", 15000);
    Combo c2 = new Combo("Tinto", 3500);

    IO.println(c1.descripcion());
    IO.println("Total sin propina: $" + c1.precioFinal());
    IO.println("Total con 10% propina: $" + c1.precioFinal(10));
    IO.println(c2.descripcion() + " -> $" + c2.precioFinal());

    try {
        new Combo("Capuchino", "Galleta", 0);
    } catch (IllegalArgumentException e) {
        IO.println("Error precio: " + e.getMessage());
    }

    try {
        new Combo("   ", 5000);
    } catch (IllegalArgumentException e) {
        IO.println("Error bebida: " + e.getMessage());
    }
}
