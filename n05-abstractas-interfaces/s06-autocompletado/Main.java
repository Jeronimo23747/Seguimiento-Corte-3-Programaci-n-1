void main() {
    Snack s = new Galleta();
    IO.println(s.nombre() + ": $" + s.precioBase());
    Descontable d = s;
    IO.println("Con 20 %: $" + d.conDescuento(20));
}
