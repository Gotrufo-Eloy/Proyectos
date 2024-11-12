DROP DATABASE IF EXISTS Ejercicio4;
CREATE DATABASE Ejercicio4;
USE Ejercicio4;

CREATE TABLE Departamento(
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_departamento VARCHAR(50) 
);

CREATE TABLE Empleado(
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    salario DECIMAL(10,2),
    fecha_contratación DATE,
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES Departamento(id_departamento)
);

CREATE TABLE Producto(
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(50),
    precio DECIMAL(10,2),
    stock INT DEFAULT 0,
    fecha_adiccion DATETIME
);

CREATE TABLE Cliente(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(50),
    correo VARCHAR(50),
    telefono CHAR
);

CREATE TABLE Pedido(
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_producto INT,
    cantidad INT CHECK (cantidad>0),
    fecha_pedido TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);



