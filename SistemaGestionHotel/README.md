# Sistema de Gestión de Hotel

Proyecto de Java basado en el análisis del problema real presentado para la asignatura.

## Funciones incluidas
- Registrar habitaciones y consultar cuáles están disponibles.
- Registrar clientes y consultar sus reservas.
- Crear y cancelar reservas.
- Calcular el costo de la estadía según el número de noches.
- Ejemplo de uso desde la clase `Main`.
- Pruebas unitarias con JUnit 5.
- Documentación JavaDoc en las clases y métodos principales.

## Clases
- `Persona`: datos generales y actualización de datos.
- `Cliente`: hereda de Persona y puede solicitar y consultar reservas.
- `Empleado`: hereda de Persona y puede iniciar sesión y gestionar reservas.
- `Habitacion`: guarda número, tipo, precio y disponibilidad.
- `Reserva`: controla la creación, cancelación y costo de una reserva.
- `Hotel`: administra las habitaciones y guarda las reservas.

## Requisitos
- JDK 17 o superior.
- Maven instalado para ejecutar las pruebas.

## Cómo ejecutar
Desde la carpeta del proyecto, abre una terminal y ejecuta:

```bash
mvn test
mvn package
java -cp target/classes hotel.Main
```

Si utilizas un IDE como IntelliJ IDEA, Eclipse o NetBeans, importa el proyecto como proyecto Maven y ejecuta la clase `hotel.Main`.

## Evidencias para la entrega
Toma capturas reales de:
1. Las clases abiertas en el IDE.
2. La salida de `Main` mostrando la creación y cancelación de una reserva.
3. La ejecución de las pruebas unitarias y el resultado de las pruebas.
4. La documentación JavaDoc generada, si el profesor la solicita.

## Repositorio
Crea un repositorio en GitHub, sube la carpeta del proyecto y pega en la entrega el enlace real que te genere GitHub. No uses un enlace inventado.
