-- Crear base de datos si no existe
DROP DATABASE IF EXISTS tienda2;
CREATE DATABASE tienda2;
USE tienda2;
-- Crear tablas de ejemplo
CREATE TABLE cliente (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    email VARCHAR(100)
);
CREATE TABLE pedido (
    id INT PRIMARY KEY,
    id_cliente INT,
    fecha DATE,
    total DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);
CREATE TABLE producto (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2)
);
CREATE TABLE linea_pedido (
    id INT PRIMARY KEY,
    id_pedido INT,
    id_producto INT,
    cantidad INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);
-- Insertar datos en la tabla cliente
INSERT INTO cliente (id, nombre, email)
VALUES (1, 'Juan Perez', 'juan.perez@example.com'),
    (2, 'Ana Gomez', 'ana.gomez@example.com'),
    (3, 'Luis Martinez', 'luis.martinez@example.com'),
    (4, 'Maria Lopez', 'maria.lopez@example.com');
-- Insertar datos en la tabla pedido
INSERT INTO pedido (id, id_cliente, fecha, total)
VALUES (1, 1, '2025-01-01', 100.50),
    (2, 1, '2025-01-10', 50.00),
    (3, 2, '2025-01-15', 75.25),
    (4, 3, '2025-01-20', 200.00);
-- Insertar datos en la tabla producto
INSERT INTO producto (id, nombre, precio)
VALUES (1, 'Laptop', 800.00),
    (2, 'Mouse', 20.00),
    (3, 'Teclado', 50.00),
    (4, 'Monitor', 150.00);
-- Insertar datos en la tabla linea_pedido
INSERT INTO linea_pedido (id, id_pedido, id_producto, cantidad)
VALUES (1, 1, 1, 1),
    (2, 1, 2, 2),
    (3, 2, 3, 1),
    (4, 3, 4, 2),
    (5, 4, 1, 1),
    (6, 4, 3, 3);
-- Ejercicios
-- Ejercicio 1: INNER JOIN - Lista de Clientes con Pedidos Realizados
SELECT Cliente.nombre AS nombreCliente,
    Pedido.fecha AS fechaPedido
FROM Cliente
    INNER JOIN Pedido ON Cliente.id = Pedido.id_cliente;

-- Ejercicio 2: INNER JOIN - Productos Vendidos en Pedidos
SELECT pedido.fecha AS fechaPedido,
    linea_pedido.cantidad AS cantidadProductos,
    producto.nombre AS nombreProducto
FROM pedido
    INNER JOIN linea_pedido ON pedido.id = linea_pedido.id_pedido
    INNER JOIN producto ON linea_pedido.id_producto = producto.id;

-- Ejercicio 3: LEFT JOIN - Clientes sin Pedidos
SELECT cliente.nombre,
    pedido.id
FROM cliente
    LEFT JOIN pedido ON cliente.id = pedido.id_cliente;

-- Ejercicio 4: LEFT JOIN - Productos No Vendidos
SELECT pedido.id,
    linea_pedido.id_producto
FROM pedido
    LEFT JOIN linea_pedido ON pedido.id = linea_pedido.id_pedido;

-- Ejercicio 5: RIGHT JOIN - Pedidos Sin Detalles Asociados
SELECT pedidos.id,
    FROM
    RIGHT JOIN ON 

-- Ejercicio 6: RIGHT JOIN - Clientes y Todos sus Pedidos (Incluyendo Nulos)
SELECT cliente.nombre,
    pedido.id
FROM cliente
    RIGHT JOIN pedido ON cliente.id = pedido.id_cliente;