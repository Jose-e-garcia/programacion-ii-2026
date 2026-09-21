# Tarea 07 - PostgreSQL Inventario

## Nombre de la actividad

Tarea 07 - PostgreSQL Inventario

## Descripción del problema

Se desarrolló una base de datos en PostgreSQL para administrar el inventario de una tienda. La base de datos permite registrar productos, consultar información, controlar existencias, actualizar el stock después de una venta, marcar como inactivos los productos agotados y eliminar registros específicos.

## Requisitos

* Crear la base de datos `control_inventario`.
* Crear la tabla `producto`.
* Utilizar restricciones para mantener la integridad de los datos.
* Registrar datos de prueba.
* Realizar consultas de búsqueda y ordenamiento.
* Simular una venta modificando el stock.
* Marcar productos agotados como inactivos.
* Probar las restricciones de código duplicado y stock negativo.
* Eliminar el producto temporal `TEMP-001`.
* Presentar las evidencias de las operaciones realizadas.

## Base de datos

**Nombre:** `control_inventario`

## Ejecución de los scripts

Los archivos SQL deben ejecutarse siguiendo este orden:

1. `database/01_creacion.sql`
2. `database/02_datos_prueba.sql`
3. `database/03_operaciones.sql`

## Archivos del proyecto

* `database/01_creacion.sql` — Creación de la base de datos y tabla `producto`.
* `database/02_datos_prueba.sql` — Inserción de productos y pruebas de restricciones.
* `database/03_operaciones.sql` — Consultas, actualización de stock, productos agotados y eliminación de `TEMP-001`.
* `evidencias/Evidencias_PostgreSQL__JoseGarcia.docx` — Documento con las evidencias de la actividad.

## Datos del estudiante

**Nombre:** JOSE ERNESTO GARCIA
**Carné:** 9941-10-13121
