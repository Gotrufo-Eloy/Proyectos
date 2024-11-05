CREATE TABLE Clientes(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimienot DATE,
    email VARCHAR(100) UNIQUE,
    telefono CHAR(10),
    direccion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 
CREATE TABLE Categorias(
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL
);
CREATE TABLE Productos(
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion MEDIUMTEXT,
    precio DECIMAL(7,2),
    stock INT DEFAULT 0,
    categoría_id INT,
    FOREIGN KEY (categoría_id) REFERENCES Categorias(categoría_id)
);
CREATE TABLE Pedidos(
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente VARCHAR(50),
    fecha_peido DATETIME,
    total DECIMAL(10,2),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
CREATE TABLE Detalles_Pedidos(
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido VARCHAR(50),
    id_producto DATETIME,
    cantidad INT DEFAULT 1,
    precio_unitario DECIMAL(7,2)
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);