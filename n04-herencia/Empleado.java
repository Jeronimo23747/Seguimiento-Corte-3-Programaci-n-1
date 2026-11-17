public class Empleado {
    private final String nombre;
    private final int salarioBase;

    public Empleado(String nombre, int salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }
    public int getSalarioBase() { return salarioBase; }

    public int pago() {
        return salarioBase;
    }

    // Extra +10 XP: sobrescribe toString()
    @Override
    public String toString() {
        return nombre + " (base $" + salarioBase + ", pago $" + pago() + ")";
    }
}
