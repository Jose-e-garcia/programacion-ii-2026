# Sistema de Estacionamiento

## Descripción

Aplicación de consola desarrollada en Java para administrar el ingreso y salida de vehículos de un estacionamiento.

El sistema permite registrar automóviles y motocicletas, calcular el costo según el tipo de vehículo y aplicar un descuento del 10% cuando el vehículo permanece más de 5 horas.

## Conceptos utilizados

* Programación Orientada a Objetos
* Abstracción
* Encapsulación
* Herencia
* Sobrescritura
* Polimorfismo
* ArrayList
* HashSet
* HashMap
* Validaciones
* Manejo básico de excepciones
* PostgreSQL
* SQL

## Funciones del sistema

1. Registrar vehículo.
2. Mostrar vehículos registrados.
3. Buscar vehículo por placa.
4. Mostrar vehículo con mayor costo.
5. Mostrar total general recaudado.
6. Mostrar total recaudado por tipo.
7. Salir.

## Estructura del proyecto

* `src/` contiene las clases Java.
* `database/` contiene el archivo SQL de PostgreSQL.
* `evidencias/` contiene las evidencias del proyecto.

## Base de datos

Base de datos utilizada:

`parcial2_estacionamiento`

Tabla:

`vehiculo`

La base de datos contiene restricciones `PRIMARY KEY`, `UNIQUE`, `NOT NULL`, `CHECK` y `DEFAULT`.

## Autor

Nombre: JOSE ERNESTO GARCIA
Carnet: 9941-10-13121
Curso: PROGRAMACIÓN II SECCIÓN C

Parcial II – Parte práctica
