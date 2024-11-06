USE ejercicio3;

CREATE TABLE Usuarios(
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 

CREATE TABLE Libros(
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    editorial VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0
);

CREATE TABLE Prestamos(
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL, 
    id_libro INT NOT NULL,
    fecha_prestamo TIMESTAMP,
    fecha_devolucion TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_libro) REFERENCES Libros(id_libro)
);

CREATE TABLE Categorias_Libros(
    id_categoria_libro INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL,
    descripcion MEDIUMTEXT
);

CREATE TABLE Categorias_Prestamos(
    id_categoria_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria_libro INT NOT NULL,
    id_prestamo INT NOT NULL,
    FOREIGN KEY (id_categoria_libro) REFERENCES Categorias_Libros(id_categoria_libro),
    FOREIGN KEY (id_prestamo) REFERENCES Prestamos(id_prestamo)
);