-- 1. Mostrar todos los productos

SELECT codigo, nombre, categoria, precio, stock
FROM producto;


-- 2. Buscar productos de una categoria especifica

SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE categoria = 'Lacteos';


-- 3. Productos ordenados del precio mas alto al mas bajo

SELECT codigo, nombre, categoria, precio, stock
FROM producto
ORDER BY precio DESC;


-- 4. Productos con tres unidades o menos

SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE stock <= 3;


-- 5. Productos activos que todavia tienen existencias

SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE activo = TRUE
  AND stock > 0;


  -- 6. Buscar un producto mediante su codigo

SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'PAN-001';


-- Stock antes de la venta

SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'PAN-001';


-- Simulacion de una venta: se venden 2 unidades

UPDATE producto
SET stock = stock - 2
WHERE codigo = 'PAN-001';

-- Stock despues de la venta

SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'PAN-001';


-- Verificar productos que seran afectados

SELECT codigo, nombre, stock, activo
FROM producto
WHERE stock = 0;

-- Marcar productos agotados como inactivos

UPDATE producto
SET activo = FALSE
WHERE stock = 0;


-- Comprobar productos inactivos

SELECT codigo, nombre, stock, activo
FROM producto
WHERE activo = FALSE;


-- Verificar que TEMP-001 existe

SELECT codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';


-- Eliminar unicamente TEMP-001

DELETE FROM producto
WHERE codigo = 'TEMP-001';


-- Verificar que TEMP-001 ya no existe

SELECT codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';

