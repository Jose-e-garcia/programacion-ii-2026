# Tarea 9 — Spring Boot: Control de Despensa API

## Datos del estudiante

**Nombre:** José Ernesto García
**Carnet:** 9941-10-13121

## Descripción del problema

El proyecto consiste en desarrollar una API REST básica para administrar y consultar información de productos de una despensa.

La aplicación trabaja con una lista de productos almacenados en memoria. Cada producto contiene un identificador, nombre, categoría, cantidad y precio unitario.

La API permite consultar todos los productos, buscar un producto por su identificador, filtrar productos por categoría, consultar productos con stock bajo, identificar el producto con mayor valor total y obtener un resumen del inventario.

No se utiliza una base de datos. Los datos se cargan directamente en memoria cuando se inicia la aplicación.

## Tecnologías utilizadas

* Java
* Spring Boot
* Spring Web
* Maven
* API REST
* JSON
* IntelliJ IDEA

## Requisitos

* Java 17 o superior
* IntelliJ IDEA
* Maven
* Spring Boot
* Navegador web o herramienta para realizar solicitudes HTTP

## Estructura del proyecto

```text
control-despensa-api
│
├── src
│   └── main
│       └── java
│           └── com.estudiante.despensa
│               ├── ControlDespensaApiApplication.java
│               │
│               ├── controller
│               │   └── ProductoController.java
│               │
│               └── model
│                   ├── Producto.java
│                   └── ResumenInventario.java
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Clases principales

### Producto

Representa un producto de la despensa.

Contiene:

* `id`
* `nombre`
* `categoria`
* `cantidad`
* `precioUnitario`

También contiene el método `calcularSubtotal()`, que obtiene el valor total del producto mediante:

```text
cantidad × precioUnitario
```

### ResumenInventario

Representa el resumen general del inventario.

Contiene:

* `cantidadProductos`
* `totalUnidades`
* `valorTotal`

### ProductoController

Contiene los endpoints REST de la aplicación y realiza las consultas sobre la lista de productos.

## Endpoints

| Método | Endpoint                               | Descripción                                      |
| ------ | -------------------------------------- | ------------------------------------------------ |
| GET    | `/api/productos`                       | Obtiene todos los productos                      |
| GET    | `/api/productos/{id}`                  | Busca un producto por ID                         |
| GET    | `/api/productos/categoria/{categoria}` | Filtra productos por categoría                   |
| GET    | `/api/productos/stock-bajo`            | Obtiene productos con cantidad menor o igual a 3 |
| GET    | `/api/productos/mayor-valor`           | Obtiene el producto con mayor subtotal           |
| GET    | `/api/productos/resumen`               | Obtiene el resumen del inventario                |

## Datos iniciales

La aplicación inicia con seis productos:

| ID | Producto | Categoría | Cantidad | Precio unitario |
| -: | -------- | --------- | -------: | --------------: |
|  1 | Arroz    | Granos    |        5 |          Q12.00 |
|  2 | Frijoles | Granos    |        3 |          Q10.00 |
|  3 | Leche    | Lacteos   |        2 |           Q8.50 |
|  4 | Queso    | Lacteos   |        4 |          Q25.00 |
|  5 | Jabon    | Limpieza  |        1 |          Q15.00 |
|  6 | Cafe     | Bebidas   |        6 |          Q30.00 |

Los datos cumplen las validaciones establecidas: los identificadores son positivos y únicos, los nombres y categorías no están vacíos, las cantidades no son negativas y los precios son mayores que cero.

## Ejemplos de respuestas JSON

### Todos los productos

Endpoint:

```text
GET /api/productos
```

Ejemplo:

```json
[
  {
    "id": 1,
    "nombre": "Arroz",
    "categoria": "Granos",
    "cantidad": 5,
    "precioUnitario": 12.0
  }
]
```

### Producto por ID

Endpoint:

```text
GET /api/productos/3
```

Respuesta:

```json
{
  "id": 3,
  "nombre": "Leche",
  "categoria": "Lacteos",
  "cantidad": 2,
  "precioUnitario": 8.5
}
```

### Resumen

Endpoint:

```text
GET /api/productos/resumen
```

Respuesta:

```json
{
  "cantidadProductos": 6,
  "totalUnidades": 21,
  "valorTotal": 402.0
}
```

## Ejecución del proyecto

Para ejecutar la aplicación:

1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que Maven cargue las dependencias.
3. Ejecutar la clase `ControlDespensaApiApplication`.
4. Esperar a que Spring Boot inicie el servidor.
5. Abrir un navegador y acceder a los endpoints.

La aplicación utiliza el puerto `8080`.

Ejemplo:

```text
http://localhost:8080/api/productos
```

## Persistencia

Los productos se almacenan únicamente en memoria utilizando una lista de Java.

Por esta razón, los datos se vuelven a cargar con los valores iniciales cada vez que la aplicación se reinicia.

## Autor

**José Ernesto García**
**Carnet:** 9941-10-13121
