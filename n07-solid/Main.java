import java.util.List;

void main() {
    var ventas = List.of(9500, 7000, 3500, 11000);

    // 1. Reporte en texto por consola
    var reporteTexto = new ReporteDiario(new FormatoTexto(), new DestinoConsola());
    reporteTexto.generar(ventas);

    // 2. Reporte en CSV por consola
    var reporteCsv = new ReporteDiario(new FormatoCsv(), new DestinoConsola());
    reporteCsv.generar(ventas);

    // 3. Extra +10 XP: FormatoJson sin tocar ReporteDiario ni Totales
    var memoria = new DestinoMemoria();
    var reporteJson = new ReporteDiario(new FormatoJson(), memoria);
    reporteJson.generar(ventas);
    IO.println("En memoria (JSON): " + memoria.enviados().getFirst());
}
