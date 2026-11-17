# Java 25 en la cafetería — Café Sintaxis

Solución completa, organizada por niveles y verificada con **OpenJDK 25.0.4.1** de todos los ejercicios de programación (S06 Autocompletado, S07 Hazlo tú + Extras, Reto Final y Evaluación) del tutorial *Java 25 en la cafetería*.

## Estructura del proyecto

Cada nivel sigue la convención de carpetas de la guía:

- [`n01-clases/`](n01-clases/Main.java) — Clases, métodos y atributos (`Barista` + [`s06-autocompletado/`](n01-clases/s06-autocompletado/Main.java) `Mesa`)
- [`n02-encapsulamiento/`](n02-encapsulamiento/Main.java) — Encapsulamiento e invariantes (`BotePropinas` + [`s06-autocompletado/`](n02-encapsulamiento/s06-autocompletado/Main.java) `TarjetaRegalo`)
- [`n03-constructores/`](n03-constructores/Main.java) — Constructores, sobrecarga y prólogo JEP 513 (`Combo` + [`s06-autocompletado/`](n03-constructores/s06-autocompletado/Main.java) `Postre`)
- [`n04-herencia/`](n04-herencia/Main.java) — Herencia y composición (`Empleado`, `Barista`, `Mesero`, `Turno` + [`s06-autocompletado/`](n04-herencia/s06-autocompletado/Main.java) `Temporada` y `Combo`)
- [`n05-abstractas-interfaces/`](n05-abstractas-interfaces/Main.java) — Clases abstractas e interfaces (`Entrega`, `EnMesa`, `ParaLlevar`, `Domicilio`, `Rastreable`, `Prioritaria` + [`s06-autocompletado/`](n05-abstractas-interfaces/s06-autocompletado/Main.java) `Snack` y `Descontable`)
- [`n06-enum/`](n06-enum/Main.java) — Enumeraciones, `switch` de flechas y `EnumMap` (`EstadoMesa` + [`s06-autocompletado/`](n06-enum/s06-autocompletado/Main.java) `Leche`)
- [`n07-solid/`](n07-solid/Main.java) — Principios SOLID (`Totales`, `Formato`, `Destino`, `ReporteDiario` + [`s06-autocompletado/`](n07-solid/s06-autocompletado/Main.java) `Cocina` e `Impresora`)
- [`n08-genericos/`](n08-genericos/Main.java) — Genéricos, límites y comodines (`Historial<T>` + [`s06-autocompletado/`](n08-genericos/s06-autocompletado/Main.java) `Bandeja<T>`)
- [`n09-crud/`](n09-crud/Main.java) — CRUD con `ArrayList`, `Optional` y menú con `IO.readln` (`Reserva`, `Agenda` + [`s06-autocompletado/`](n09-crud/s06-autocompletado/Main.java))
- [`n10-records/`](n10-records/Main.java) — Records inmutables y patrones (`ItemMenu`, `MenuDelDia`, `Categoria` + [`s06-autocompletado/`](n10-records/s06-autocompletado/Main.java) `Calificacion`)
- [`n11-serializacion/`](n11-serializacion/Main.java) — Serialización moderna con `ObjectInputFilter` y exportación CSV (`Reserva`, `ArchivoReservas`, `Agenda` + [`s06-autocompletado/`](n11-serializacion/s06-autocompletado/Main.java) `Turno`)
- [`reto-final-cafe-sintaxis/`](reto-final-cafe-sintaxis/Main.java) — **Café Sintaxis 1.0**: sistema integrado de los 11 niveles
- [`SOLUCIONES_TEORICAS.md`](SOLUCIONES_TEORICAS.md) — Respuestas a todas las evaluaciones (S08 P1–P8) y retos de autocompletado (S06)

## Cómo ejecutar cualquier nivel

Desde la carpeta del nivel (por ejemplo `n01-clases`), ejecuta:

```powershell
C:\Users\USUARIO\.jdks\jbr-25.0.4.1\bin\java.exe Main.java
```
