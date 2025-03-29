-- Crear base de datos si no existe
DROP DATABASE IF EXISTS billar;
CREATE DATABASE billar;
USE billar;

-- Crear tabla de jugadores
CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Crear tabla de mesas de billar
CREATE TABLE mesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    tipo VARCHAR(20) -- Ej: "Pool", "Snooker", "Carambola"
);

-- Crear tabla de torneos
CREATE TABLE torneo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    fecha DATE
);

-- Crear tabla de tacos de billar
CREATE TABLE taco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50),
    material VARCHAR(30) -- Ej: "Madera", "Fibra de carbono"
);

-- Insertar datos en la tabla jugador
INSERT INTO jugador (nombre) VALUES
('Carlos'),
('Andrea'),
('Miguel'),
('Lucía'),
('Fernando');

-- Insertar datos en la tabla mesa
INSERT INTO mesa (numero, tipo) VALUES
(1, 'Pool'),
(2, 'Snooker'),
(3, 'Carambola'),
(4, 'Pool');

-- Insertar datos en la tabla torneo
INSERT INTO torneo (nombre, fecha) VALUES
('Torneo de Verano', '2025-06-15'),
('Copa Nacional', '2025-09-20'),
('Desafío Internacional', '2025-12-05');

-- Insertar datos en la tabla taco
INSERT INTO taco (marca, material) VALUES
('Predator', 'Madera'),
('Cuetec', 'Fibra de carbono'),
('McDermott', 'Madera'),
('Lucasi', 'Fibra de carbono');

-- ALTER TABLE: Añadir una clave foránea en la tabla 'jugador' para asociarlo con la tabla 'torneo'.
ALTER TABLE jugador ADD COLUMN torneo_id INT;
ALTER TABLE jugador ADD CONSTRAINT fk_jugador_torneo FOREIGN KEY (torneo_id) REFERENCES torneo(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'jugador' para asociarlo con la tabla 'taco'.
ALTER TABLE jugador ADD COLUMN taco_id INT;
ALTER TABLE jugador ADD CONSTRAINT fk_jugador_taco FOREIGN KEY (taco_id) REFERENCES taco(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'mesa' para asociarla con la tabla 'torneo'.
ALTER TABLE mesa ADD COLUMN torneo_id INT;
ALTER TABLE mesa ADD CONSTRAINT fk_mesa_torneo FOREIGN KEY (torneo_id) REFERENCES torneo(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'torneo' para indicar qué jugador organizó el torneo.
ALTER TABLE torneo ADD COLUMN organizador_id INT;
ALTER TABLE torneo ADD CONSTRAINT fk_torneo_organizador FOREIGN KEY (organizador_id) REFERENCES jugador(id);

-- ALTER TABLE: Modificar el tamaño del campo 'nombre' en la tabla 'jugador' para permitir hasta 100 caracteres.

-- ALTER TABLE: Eliminar la columna 'material' en la tabla 'taco'.

-- ALTER TABLE: Cambiar el nombre de la columna 'numero' en la tabla 'mesa' por 'identificador_mesa'.

-- ALTER TABLE: Añadir una nueva columna 'telefono' en la tabla 'jugador' para almacenar su número de contacto.

-- ALTER TABLE: Añadir una restricción UNIQUE para que los nombres de torneos sean únicos.

-- ALTER TABLE: Añadir una restricción CHECK para que las fechas de los torneos sean posteriores al año 2025.

-- ALTER TABLE: Añadir una clave foránea en la tabla 'jugador' para indicar en qué mesa está jugando actualmente.
ALTER TABLE jugador ADD COLUMN mesa_id INT;
ALTER TABLE jugador ADD CONSTRAINT fk_jugador_mesa FOREIGN KEY (mesa_id) REFERENCES mesa(id);


-- UPDATE: Asignar a cada jugador un torneo en el que participará.
-- Carlos y Andrea participarán en el "Torneo de Verano".

-- Miguel y Lucía participarán en la "Copa Nacional".

-- Fernando participará en el "Desafío Internacional".

-- UPDATE: Asignar un taco de billar a cada jugador.
-- Carlos usará un taco de la marca Predator.

-- Andrea usará un taco de la marca Cuetec.

-- Miguel usará un taco de la marca McDermott.

-- Lucía usará un taco de la marca Lucasi.

-- Fernando usará un taco de la marca Predator.

-- UPDATE: Asignar mesas a los torneos.
-- Las mesas 1 y 2 se usarán en el "Torneo de Verano".

-- La mesa 3 se usará en la "Copa Nacional".

-- La mesa 4 se usará en el "Desafío Internacional".

-- CONDICIÓN: Asignar un torneo a todos los jugadores que no tengan torneo asignado aún.

-- CONDICIÓN: Asignar un taco aleatorio a los jugadores que no tengan taco asignado.

-- CONDICIÓN: Cambiar el torneo de todos los jugadores que actualmente participan en torneos entre julio y noviembre.


-- CONDICIÓN: Cambiar la mesa de todos los torneos que se celebren después del 1 de diciembre de 2025.


-- CONDICIÓN: Asignar un torneo a todas las mesas que aún no tienen torneo asignado.

-- CONDICIÓN: Cambiar el taco de todos los jugadores que tengan un taco de fibra de carbono a un taco de madera.


-- CONDICIÓN: Cambiar el torneo de todas las mesas que sean de tipo "Pool" al "Torneo de Verano".