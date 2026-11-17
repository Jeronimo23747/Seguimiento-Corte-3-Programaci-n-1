// Extra +10 XP: nuevo formato sin modificar ninguna clase existente
public class FormatoJson implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "{\"ventas\": " + ventas + ", \"total\": " + total + "}";
    }
}
