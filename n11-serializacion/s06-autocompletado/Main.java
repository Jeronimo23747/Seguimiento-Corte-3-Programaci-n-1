void main() throws Exception {
    Path f = Path.of("turno.ser");
    try (var out = new ObjectOutputStream(
            Files.newOutputStream(f))) {
        out.writeObject(new Turno("Martín", 42));
    }
    try (var in = new ObjectInputStream(
            Files.newInputStream(f))) {
        in.setObjectInputFilter(
                ObjectInputFilter.Config.createFilter("Turno;!*"));
        Turno t = (Turno) in.readObject();
        IO.println(t + " · " + Files.size(f) + " bytes");
    }
}
