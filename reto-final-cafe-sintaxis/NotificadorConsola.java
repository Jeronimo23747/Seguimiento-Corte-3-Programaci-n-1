public class NotificadorConsola implements Notificador {
    @Override
    public void enviar(String destino, String mensaje) {
        IO.println("[Notificación -> " + destino + "] " + mensaje);
    }
}
