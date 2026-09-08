# Tarea 6 - Colecciones y Excepciones

## Descripción

Programa desarrollado en Java para controlar el registro de productos y calcular los gastos de una compra.

El programa permite registrar productos, validar los datos ingresados, calcular subtotales y obtener diferentes estadísticas utilizando colecciones de Java.

## Colecciones utilizadas

### ArrayList<Producto>

Se utiliza para almacenar todos los productos registrados. Permite mantener los productos en el orden en que fueron ingresados.

### HashSet<String>

Se utiliza para almacenar las categorías de los productos sin permitir categorías duplicadas.

### HashMap<String, Double>

Se utiliza para almacenar el total gastado por cada categoría, utilizando la categoría como clave y el total gastado como valor.

## Funcionalidades

El programa permite:

* Registrar un mínimo de 5 productos.
* Validar que el nombre no esté vacío.
* Validar que la categoría no esté vacía.
* Validar que el precio unitario sea mayor que cero.
* Validar que la cantidad sea mayor que cero.
* Calcular el subtotal de cada producto.
* Mostrar todos los productos registrados.
* Mostrar las categorías sin duplicados.
* Calcular el total de productos registrados.
* Calcular el total general de la compra.
* Identificar el producto con mayor gasto.
* Identificar el producto con menor gasto.
* Calcular el total gastado por categoría.
* Identificar la categoría con mayor gasto.
* Consultar el total gastado en una categoría.
* Informar cuando una categoría consultada no existe.

## Ejemplo de cálculo

Para un producto con:

* Precio unitario: Q10.00
* Cantidad: 1

El subtotal es:

**Q10.00 × 1 = Q10.00**

El total general se obtiene sumando los subtotales de todos los productos registrados.

## Validaciones realizadas

Se realizaron pruebas con valores inválidos de precio y cantidad.

* Precio igual a 0: producto rechazado.
* Cantidad igual a 0: producto rechazado.
* Cantidad negativa: producto rechazado.
* El programa continúa solicitando productos hasta completar 5 productos válidos.

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Colecciones de Java: ArrayList, HashSet y HashMap

## Autor

José Ernesto García
9941-10-13121
