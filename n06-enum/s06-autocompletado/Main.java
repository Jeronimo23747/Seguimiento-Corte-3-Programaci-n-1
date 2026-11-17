void main() {
    for (Leche l : Leche.values()) {
        if (l.vegetal()) {
            IO.println(l + " +$" + l.recargo());
        }
    }
}
