# Soluciones Teóricas y Evaluaciones (Niveles 01 al 11)

## Nivel 01 · Clases, métodos y atributos
- **S06 Autocompletado (`Mesa`)**: `1: class`, `2: boolean`, `3: void`, `4: return`, `5: new`, `6: ocupar`, `7: estado`.
  - *Pregunta de control*: El espacio 3 no puede ser `boolean` porque el método no tiene sentencia `return`; para serlo debería devolver `true` o `false`.
- **S08 Evaluación**:
  1. `b` (`new`)
  2. **F** — Cada objeto guarda sus propios valores en sus atributos de instancia.
  3. Atributo → `int stock;` | Método → `boolean hayStock()` | Objeto → `latte` | Parámetro → `int cantidad`
  4. Orden: `1` Escribir la clase Producto → `2` Crear el objeto con new → `3` Asignar nombre, precio y stock → `4` Llamar a latte.vender(2) → `5` Imprimir el resultado con IO.println
  5. `b` (El atributo no existe con ese nombre)
  6. `vender` devuelve `int` para entregar el total a cobrar a la caja; si fuera `void`, el programa no sabría cuánto cobrar.
  7. No: `String` no permite operaciones aritméticas directas ni multiplicaciones como `cantidad * precio` sin convertir primero.
  8. `public class Domicilio { String direccion; boolean despachado; void despachar() { despachado = true; } }`

## Nivel 02 · Encapsulamiento
- **S06 Autocompletado (`TarjetaRegalo`)**: `1: private`, `2: getSaldo`, `3: <=`, `4: IllegalArgumentException`, `5: boolean`, `6: return`, `7: getSaldo`.
  - *Pregunta de control*: Si fuera `public`, cualquiera podría escribir `t.saldo = -5000;` rompiendo el invariante.
- **S08 Evaluación**:
  1. `c` (`private`)
  2. **F** — Un getter solo consulta y devuelve el valor; no lo modifica.
  3. `private` → Esconde el dato | `getSaldo()` → Consulta sin cambiar | `throw` → Rechaza un dato inválido | `catch` → Responde al error
  4. Orden: `1` Recibir el valor → `2` Revisar si es 0 o menos → `3` Lanzar la excepción si lo es → `4` Sumar al saldo → `5` Contar la venta
  5. `b` (Usar `caja.cobrar(…)` o `getSaldo()`)
  6. El parámetro `precio` se asigna a sí mismo (sombreado) y el atributo `this.precio` nunca cambia.
  7. No: un `setSaldo` público permitiría sobrescribir el saldo arbitrariamente sin registrar ventas ni validar el invariante de caja.
  8. `public class Termo { private int ml; public Termo(int ml) { this.ml = ml; } public int getMl() { return ml; } public void servir(int cantidad) { if (cantidad > ml) throw new IllegalArgumentException("No alcanza"); ml -= cantidad; } }`

## Nivel 03 · Constructores y sobrecarga
- **S06 Autocompletado (`Postre`)**: `1: Postre`, `2: this`, `3: this`, `4: false`, `5: boolean`, `6: etiqueta`, `7: new`.
  - *Pregunta de control*: Los constructores no tienen tipo de retorno; si pones `void`, pasa a ser un método normal y `new Postre(...)` deja de invocarlo.
- **S08 Evaluación**:
  1. `b` (Usa el nombre de la clase y no tiene tipo de retorno)
  2. **F** — La sobrecarga requiere distinta lista de parámetros (número o tipos); cambiar solo el tipo de retorno no compila.
  3. `this.precio` → El atributo del objeto | `this(…)` → Llama a otro constructor | `final` → Se asigna una sola vez | `Prólogo` → Validar antes de delegar
  4. Orden: `1` Java elige el constructor de 2 parámetros → `2` El prólogo valida el nombre → `3` `this(…)` llama al constructor completo → `4` Se valida el precio → `5` Se asignan los 4 campos
  5. `b` (El constructor por defecto solo existe si no declaras ninguno)
  6. Evita duplicar validaciones y asignaciones; las reglas de negocio viven en un único constructor.
  7. Con setters un objeto puede nacer incompleto (por ejemplo, un capuchino con precio `$0`) si se olvida llamar a un setter.
  8. `public Domicilio(String direccion, int valor) { this.direccion = direccion; this.valor = valor; } public Domicilio(String direccion) { this(direccion, 4000); }`

## Nivel 04 · Herencia y composición
- **S06 Autocompletado (`Temporada`, `Combo`)**: `1: extends`, `2: super`, `3: @Override`, `4: super`, `5: Producto`, `6: getPrecio`, `7: Temporada`.
  - *Pregunta de control*: Un `Combo` no *es un* `Producto`, sino que *tiene* dos `Producto`s (relación «tiene un» → composición).
- **S08 Evaluación**:
  1. `b` (`extends`)
  2. **F** — Java solo admite herencia simple de clases (una sola superclase directa).
  3. `super(…)` → Llama al constructor del padre | `@Override` → Confirma la sobrescritura | `super.descripcion()` → Reusa el método del padre | `List<LineaPedido>` → Composición
  4. Orden: `1` Java elige el constructor de Bebida → `2` `super(…)` ejecuta el constructor de Producto → `3` Se asignan nombre y precio → `4` Se asigna ml → `5` La variable recibe el objeto
  5. `b` (Cada objeto usa su propia versión sobrescrita — polimorfismo)
  6. Un `Pedido` *tiene* varias `LineaPedido`, no *es una* `LineaPedido`; si heredara, mezclaría responsabilidades y rompería el diseño.
  7. `Bebida`, `Postre` y `Galleta` respecto a `Producto`, porque todos *son* productos del menú y comparten nombre, precio y ficha.
  8. `public class Te extends Bebida { private final String origen; public Te(String n, int p, int ml, String origen) { super(n, p, ml); this.origen = origen; } @Override public String descripcion() { return super.descripcion() + " · " + origen; } }`

## Nivel 05 · Clases abstractas e interfaces
- **S06 Autocompletado (`Descontable`, `Snack`, `Galleta`)**: `1: interface`, `2: default`, `3: abstract`, `4: implements`, `5: abstract`, `6: extends`, `7: Descontable`.
  - *Pregunta de control*: `Snack` no necesita escribir `conDescuento` porque lo hereda como método `default` de `Descontable`, pero sí implementa `precioBase()` que es abstracto.
- **S08 Evaluación**:
  1. `b` (Crear objetos con `new`)
  2. **V** — Una clase puede implementar múltiples interfaces separadas por coma (`implements A, B`).
  3. `abstract` → Plantilla o método sin cuerpo | `interface` → Declara un contrato | `implements` → Firma un contrato | `default` → Método con cuerpo en una interfaz
  4. Orden: `1` Leer la interfaz MedioDePago → `2` Crear la clase que la implementa → `3` Escribir nombre() y pagar() → `4` Agregar un objeto a la lista de medios → `5` Ejecutar y comparar la salida
  5. `b` (Escribir el método abstracto en `Postre`)
  6. Porque `cobrar` programa contra la interfaz `MedioDePago`, no contra una clase concreta.
  7. Perdería la capacidad de guardar atributos de instancia privados (`nombre`, `precio`) y constructores compartidos; ganaría poder implementarla en clases de familias distintas.
  8. `public interface Imprimible { String texto(); default void imprimir() { IO.println(texto()); } }`

## Nivel 06 · Enum: valores con nombre
- **S06 Autocompletado (`Leche`)**: `1: enum`, `2: final`, `3: Leche`, `4: switch`, `5: default`, `6: values`, `7: recargo`.
  - *Pregunta de control*: Porque el `switch` solo lista `AVENA` y `ALMENDRAS` y faltan `ENTERA` y `DESLACTOSADA`. Si se listan los 4 casos explícitamente, ya no necesita `default`.
- **S08 Evaluación**:
  1. `b` (`values()`)
  2. **F** — Los constructores de un `enum` son privados; no se pueden crear constantes nuevas con `new`.
  3. `Tamano.GRANDE.ml()` → `470` | `Tamano.MEDIANO.ordinal()` → `1` | `Tamano.PEQUENO.name()` → `"PEQUENO"` | `Tamano.values().length` → `3`
  4. Orden: `1` `RECIBIDO` → `2` `EN_PREPARACION` → `3` `LISTO` → `4` `ENTREGADO`
  5. `b` (El nombre debe coincidir exacto: `GRANDE`)
  6. El `switch` sin `default` exige exhaustividad; al fallar la compilación, el compilador avisa exactamente dónde falta manejar el nuevo estado.
  7. Guardar el nombre (`name()`) en lugar de `ordinal()`, porque si se reordena o inserta un valor en el `enum`, los números `ordinal()` cambian y corrompen los datos.
  8. `public enum MedioPago { EFECTIVO(0), TARJETA(2), BILLETERA(1); private final int comisionPct; MedioPago(int c) { this.comisionPct = c; } public int neto(int valor) { return valor * (100 - comisionPct) / 100; } }`

## Nivel 07 · Principios SOLID
- **S06 Autocompletado (`Impresora`, `Cocina`)**: `1: interface`, `2: implements`, `3: final`, `4: Impresora`, `5: impresora`, `6: imprimir`, `7: ImpresoraConsola`.
  - *Pregunta de control*: Inversión de dependencias (D); permite inyectar un doble de prueba en memoria para testear `Cocina` sin imprimir en consola real.
- **S08 Evaluación**:
  1. `b` (O — Abierto/cerrado)
  2. **V** — Permite sustituir la dependencia real por un doble de prueba en memoria.
  3. `S` → ¿Cuántas razones tiene para cambiar? | `L` → ¿La hija cumple lo que promete el padre? | `I` → ¿Obligo a escribir métodos que no se usan? | `D` → ¿Dependo de interfaces o de detalles?
  4. Orden: `1` Guardar la salida actual → `2` Separar una responsabilidad → `3` Ejecutar y comparar la salida → `4` Repetir con la siguiente → `5` Recién entonces mejorar comportamiento
  5. `b` (Sustitución de Liskov: rompía el contrato «nunca negativo»)
  6. `Main` actúa como ensamblador; así `Caja` queda desacoplada de implementaciones concretas y es fácil cambiar o probar el notificador.
  7. No: sobrediseñar un script de 20 líneas añade complejidad innecesaria sin cambios reales que proteger.
  8. `public class HoraFeliz implements Descuento { public int aplicar(int total) { return Math.max(0, total * 70 / 100); } }`

## Nivel 08 · Genéricos
- **S06 Autocompletado (`Bandeja`)**: `1: <T>`, `2: T`, `3: <>`, `4: T`, `5: T`, `6: String`, `7: cantidad`.
  - *Pregunta de control*: Todas se refieren al mismo parámetro de tipo `T` de la bandeja. Si `primera()` devolviera `Object`, el llamador perdería el tipo y necesitaría hacer cast a `String`.
- **S08 Evaluación**:
  1. `c` (`?`)
  2. **V** — El compilador garantiza seguridad de tipos y rechaza un `Cliente` en `Repositorio<Producto>`.
  3. `<T>` → Parámetro de tipo | `new ArrayList<>()` → Diamante | `T extends Identificable` → Parámetro acotado | `? extends Producto` → Comodín acotado
  4. Orden: `1` Detectar dos clases que solo cambian de tipo → `2` Agregar `<T>` a una de ellas → `3` Cambiar el tipo concreto por `T` → `4` Acotar `T` si se llaman métodos suyos → `5` Borrar la copia y probar con ambos tipos
  5. `b` (`String` no implementa `Identificable`)
  6. Sin genéricos el compilador no verifica el tipo real y falla en tiempo de ejecución (`ClassCastException`); con genéricos falla al compilar antes de llegar a caja.
  7. `List<Object>` pierde la seguridad de tipos y obliga a hacer casts manuales propensos a error.
  8. `<T> List<T> primeros(List<T> l, int n) { return l.subList(0, Math.min(n, l.size())); }` — llamada: `primeros(List.of("Latte", "Tinto", "Moka"), 2)`.

## Nivel 09 · CRUD paso a paso con ArrayList
- **S06 Autocompletado (`Main`)**: `1: ArrayList`, `2: add`, `3: size`, `4: getFirst`, `5: set`, `6: removeIf`, `7: contains`.
  - *Pregunta de control*: Porque si un elemento se movió de índice, borrar por posición eliminaría el elemento equivocado; la lambda busca por condición.
- **S08 Evaluación**:
  1. `b` (`Update`: actualizar)
  2. **F** — `get(i)` en `ArrayList` es tiempo constante $O(1)$, no depende del tamaño.
  3. Crear → `add` | Leer uno → `buscar(id)` | Actualizar → `setCantidad` | Eliminar → `removeIf`
  4. Orden: `1` Buscar el insumo por id → `2` Si la caja está vacía, devolver `false` → `3` Sacar el insumo del `Optional` → `4` Cambiar la cantidad → `5` Devolver `true`
  5. `b` (`listar()` devuelve una copia inmutable que no se puede modificar)
  6. Devuelve `Optional.empty()`; obliga al llamador a manejar la ausencia y evita `NullPointerException`.
  7. No: buscar por id en `ArrayList` es lineal $O(n)$; con 50 000 elementos conviene un `Map<Integer, Producto>` para búsqueda por clave en $O(1)$.
  8. `public boolean existe(String nombre) { for (Insumo i : insumos) { if (i.getNombre().equalsIgnoreCase(nombre)) return true; } return false; }`

## Nivel 10 · Records: datos inmutables
- **S06 Autocompletado (`Calificacion`)**: `1: record`, `2: Calificacion`, `3: estrellas`, `4: cliente`, `5: esBuena`, `6: equals`, `7: a`.
  - *Pregunta de control*: En un `record`, los métodos de acceso llevan exactamente el nombre del componente (`cliente()`), sin el prefijo `get`.
- **S08 Evaluación**:
  1. `b` (`precio()`)
  2. **V** — Java genera `equals` comparando todos los componentes por valor.
  3. Encabezado → Declara los componentes | Constructor compacto → Valida antes de asignar | `List.copyOf` → Protege la lista interna | Patrón de record → Extrae los componentes
  4. Orden: `1` Java elige el constructor canónico → `2` Corre el cuerpo del compacto → `3` Se valida la cantidad → `4` Se asignan los tres campos → `5` La variable recibe el record
  5. `b` (Los campos de un `record` son `final`)
  6. Para garantizar inmutabilidad superficial; sin `List.copyOf`, quien pasó la lista original podría modificarla desde afuera alterando el total del recibo.
  7. No: `Insumo` en el nivel 9 cambia de cantidad constantemente; un `record` es mejor para datos inmutables como recibos o registros históricos.
  8. `public record Propina(String barista, int valor) { public Propina { if (valor < 0) throw new IllegalArgumentException("Propina negativa"); } }`

## Nivel 11 · Serialización moderna con archivos
- **S06 Autocompletado (`Turno`)**: `1: Serializable`, `2: Path`, `3: try`, `4: ObjectOutputStream`, `5: writeObject`, `6: readObject`, `7: size`.
  - *Pregunta de control*: El `try` con recursos cierra el flujo automáticamente al terminar el bloque, incluso si ocurre una excepción.
- **S08 Evaluación**:
  1. `b` (`Serializable`)
  2. **V** — Al deserializar un `record`, Java invoca su constructor canónico, ejecutando nuevamente sus validaciones.
  3. `writeObject` → Objetos a bytes | `readObject` → Bytes a objetos | `try (var …)` → Cierra el flujo solo | `!*` en el filtro → Rechaza todo lo demás
  4. Orden: `1` Revisar si el archivo existe → `2` Abrir el `ObjectInputStream` en un `try` → `3` Poner el filtro de clases → `4` Leer el objeto → `5` Devolver la lista
  5. `b` (El archivo trae una clase que no está en la lista blanca)
  6. Porque al deserializar el `record Insumo`, Java ejecuta automáticamente su constructor canónico, que valida `cantidad < 0` y lanza la excepción.
  7. `.csv`: es texto legible, independiente del lenguaje y fácil de abrir en cualquier sistema, mientras `.ser` es binario exclusivo de Java.
  8. `in.setObjectInputFilter(ObjectInputFilter.Config.createFilter("Turno;!*")); Turno t = (Turno) in.readObject();`
