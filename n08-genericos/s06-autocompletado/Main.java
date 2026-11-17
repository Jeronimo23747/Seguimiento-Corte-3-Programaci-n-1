void main() {
    Bandeja<String> b = new Bandeja<>(2);
    b.poner("latte");
    b.poner("moka");
    IO.println("¿Cabe un tinto? " + b.poner("tinto"));
    IO.println(b.primera() + " · " + b.cantidad());
}
