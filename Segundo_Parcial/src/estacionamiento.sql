CREATE DATABASE parcial2_estacionamiento;

CREATE TABLE vehiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(20) NOT NULL UNIQUE,
    propietario VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    hora_ingreso TIME NOT NULL,
    horas_utilizadas INTEGER NOT NULL CHECK (horas_utilizadas > 0),
    costo NUMERIC(10,2) NOT NULL CHECK (costo >= 0),
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('P001ABC', 'Jose', 'Automovil', '08:00', 3, 30.00),
('M001ABC', 'Carlos', 'Motocicleta', '09:00', 6, 32.40),
('P002DEF', 'Ana', 'Automovil', '07:30', 6, 54.00),
('M002DEF', 'Luis', 'Motocicleta', '10:00', 4, 24.00),
('P003GHI', 'Maria', 'Automovil', '11:00', 2, 20.00);

SELECT id, placa, propietario, tipo,
       hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo;

SELECT id, placa, propietario, tipo, costo
FROM vehiculo
WHERE tipo = 'Automovil';

SELECT id, placa, propietario, tipo, costo
FROM vehiculo
WHERE costo > 30;

SELECT id, placa, propietario, tipo, costo
FROM vehiculo
ORDER BY costo DESC;

UPDATE vehiculo
SET costo = 35.00
WHERE placa = 'M001ABC';

SELECT id, placa, propietario, tipo, costo
FROM vehiculo
WHERE placa = 'M001ABC';

UPDATE vehiculo
SET activo = FALSE
WHERE placa = 'P003GHI';

SELECT id, placa, propietario, tipo, costo, activo
FROM vehiculo
WHERE placa = 'P003GHI';

DELETE FROM vehiculo
WHERE placa = 'M002DEF';

SELECT id, placa, propietario, tipo, costo, activo
FROM vehiculo;

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('P001ABC', 'Persona Prueba', 'Automovil', '12:00', 2, 20.00);

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('X999ZZZ', 'Prueba', 'Automovil', '12:00', 0, 20.00);