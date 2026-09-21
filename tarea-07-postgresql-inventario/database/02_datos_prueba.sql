-- Datos de prueba para la tabla producto

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PAN-001', 'Pan integral', 'Panaderia', 12.50, 10, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PAN-002', 'Croissant', 'Panaderia', 8.00, 3, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('LAC-001', 'Leche entera', 'Lacteos', 9.50, 15, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('LAC-002', 'Queso fresco', 'Lacteos', 25.00, 0);



INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('BEB-001', 'Jugo de naranja', 'Bebidas', 14.00, 7, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('BEB-002', 'Agua pura', 'Bebidas', 5.00, 2, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('LIM-001', 'Detergente', 'Limpieza', 32.50, 6, TRUE);

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('LIM-002', 'Jabon liquido', 'Limpieza', 18.75, 4, TRUE);


-- Producto temporal para probar DELETE

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('TEMP-001', 'Producto temporal', 'Pruebas', 10.00, 5, TRUE);

SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';


-- Prueba de restriccion UNIQUE: codigo duplicado

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('PAN-001', 'Producto duplicado', 'Pruebas', 20.00, 5, TRUE);


-- Prueba de restriccion CHECK: stock negativo

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('ERR-001', 'Producto con stock invalido', 'Pruebas', 15.00, -5, TRUE);


-- Correccion de la prueba de stock negativo

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('ERR-001', 'Producto corregido', 'Pruebas', 15.00, 5, TRUE);


-- Correccion de la prueba de codigo duplicado

INSERT INTO producto (codigo, nombre, categoria, precio, stock, activo)
VALUES ('COR-001', 'Producto corregido', 'Pruebas', 20.00, 5, TRUE);


SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto; 