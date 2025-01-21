-- Elimina la base de datos si ya existe
drop database if exists nevadashopping;
-- Crea la base de datos
create database nevadashopping;
use nevadashopping;
-- Tabla empleados
create table empleados (
    id int primary key,
    nombre varchar(50),
    departamento varchar(50),
    salario decimal(10, 2),
    ciudad varchar(50),
    edad int
);
-- Inserta datos en la tabla empleados
insert into empleados
values (1, 'Laura', 'IT', 4500.00, 'Madrid', 35),
    (2, 'Carlos', 'Ventas', 3200.00, 'Barcelona', 28),
    (3, 'Ana', 'Marketing', 6000.00, 'Madrid', 45),
    (
        4,
        'Juan',
        'Recursos Humanos',
        5200.00,
        'Sevilla',
        50
    ),
    (5, 'Luis', 'IT', 3400.00, 'Madrid', 29),
    (
        6,
        'Marta',
        'Desarrollo',
        5800.00,
        'Valencia',
        33
    ),
    (7, 'Pablo', 'Marketing', 3900.00, 'Madrid', 41),
    (8, 'Elena', 'Ventas', 3100.00, 'Barcelona', 26),
    (
        9,
        'Alberto',
        'Desarrollo',
        4300.00,
        'Valencia',
        36
    ),
    (10, 'Isabel', 'IT', 4800.00, 'Madrid', 30),
    (11, 'Laura', 'Marketing', 4500.00, 'Madrid', 35),
    (
        12,
        'Carlos',
        'Desarrollo',
        3200.00,
        'Barcelona',
        28
    );

    -- Tabla departamentos
create table departamentos (
    id int primary key,
    nombre varchar(50)
);

-- Inserta datos en la tabla departamentos
insert into departamentos values
(1, 'IT'),
(2, 'Ventas'),
(3, 'Marketing'),
(4, 'Recursos Humanos'),
(5, 'Desarrollo');
-- Tabla ventas
create table ventas (
    id int primary key,
    empleado_id int,
    cliente varchar(50),
    importe decimal(10, 2),
    fecha date
);
-- Inserta datos en la tabla ventas
insert into ventas
values (1, 1, 'Cliente A', 2000.00, '2024-01-10'),
    (2, 2, 'Cliente B', 1500.00, '2024-01-11'),
    (3, 3, 'Cliente C', 3000.00, '2024-01-12'),
    (4, 4, 'Cliente D', 4000.00, '2024-01-13'),
    (5, 5, 'Cliente E', 3500.00, '2024-01-14'),
    (6, 6, 'Cliente F', 5000.00, '2024-01-15'),
    (7, 7, 'Cliente G', 4500.00, '2024-01-16'),
    (8, 8, 'Cliente H', 2800.00, '2024-01-17'),
    (9, 9, 'Cliente I', 3300.00, '2024-01-18'),
    (10, 10, 'Cliente J', 4700.00, '2024-01-19'),
    (11, 1, 'Cliente K', 1500.00, '2024-01-20'),
    (12, 2, 'Cliente L', 1800.00, '2024-01-21');
-- Relación de ejercicios prácticos
-- 1. Encuentra el número total de empleados por departamento.
SELECT departamento,
    COUNT(*) AS cantidadEmpleados
FROM empleados
GROUP BY departamento;
-- 2. Calcula el salario promedio por ciudad, mostrando solo las ciudades con un salario promedio mayor a 4000.
SELECT ciudad,
    AVG(salario) AS salarioPromedio
FROM empleados
GROUP BY ciudad
HAVING salarioPromedio > 4000;
-- 3. Encuentra el total de ventas por cada cliente.
SELECT cliente,
    SUM(importe) AS totalVentas
FROM ventas
GROUP BY cliente;
-- 4. Muestra los departamentos con más de 3 empleados.
SELECT departamento,
    COUNT(*) AS cantidadEmpleados
FROM empleados
GROUP BY departamento
HAVING cantidadEmpleados >= 3;
-- 5. Calcula el promedio de edad de los empleados por ciudad.
SELECT ciudad,
    AVG(edad) AS edadPromedio
FROM empleados
GROUP BY ciudad;
-- 6. Muestra las ciudades en las que hay empleados, sin duplicados.
SELECT DISTINCT ciudad,
    COUNT(*) AS numeroEmpleados
FROM empleados
GROUP BY ciudad
HAVING numeroEmpleados > 0;
-- 7. Muestra el número total de ventas y la suma total de importes.
SELECT COUNT(*) AS numeroVentas,
    SUM(importe) AS sumaTotalImporte
FROM ventas;
-- 8. Encuentra el cliente con la venta más baja.
SELECT cliente,
    importe
FROM ventas
WHERE importe = (
        SELECT MIN(importe)
        FROM ventas
    );
-- 9. Encuentra el cliente que realizó la venta de mayor importe.
SELECT cliente,
    importe
FROM ventas
WHERE importe = (
        SELECT MAX(importe)
        FROM ventas
    );
-- 10. Encuentra los empleados con un salario mayor al promedio de todos los salarios.
SELECT nombre,
    salario
FROM empleados
WHERE salario >(
        SELECT AVG(salario)
        FROM empleados
    );

-- Ejercicios de Subconsultas

-- 1. Lista los nombres de empleados que trabajan en departamentos existentes en la tabla departamentos.
SELECT nombre FROM empleados WHERE departamento IN (SELECT nombre FROM departamentos);
-- 2. Encuentra todos los empleados cuyo salario sea mayor a 4000 y muestra su nombre y salario.
SELECT nombre, salario FROM empleados WHERE salario>4000;
-- 3. Encuentra el nombre del empleado con el salario más alto.
SELECT nombre, salario FROM empleados WHERE salario = (SELECT MAX(salario) FROM empleados);
-- 4. Calcula el promedio de salarios por departamento y muestra los departamentos con un salario promedio mayor a 5000.
SELECT departamento, AVG(salario) AS salarioPromedio FROM empleados GROUP BY departamento HAVING salarioPromedio > 5000;

-- 5. Encuentra los clientes que han realizado ventas superiores al promedio de todas las ventas.
SELECT cliente, importe FROM ventas WHERE importe > (SELECT AVG(importe) FROM ventas);