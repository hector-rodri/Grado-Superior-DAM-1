CREATE TABLE cliente (
  id NUMBER PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100),
  ciudad VARCHAR(100),
  categoría NUMBER
);

CREATE TABLE comercial (
  id NUMBER PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100),
  comision FLOAT
);

CREATE TABLE pedido (
  id NUMBER PRIMARY KEY,
  total NUMBER NOT NULL,
  fecha DATE,
  id_cliente NUMBER NOT NULL,
  id_comercial NUMBER NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES cliente(id),
  FOREIGN KEY (id_comercial) REFERENCES comercial(id)
);

INSERT INTO cliente VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);
INSERT INTO cliente VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);
INSERT INTO cliente VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);
INSERT INTO cliente VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300);
INSERT INTO cliente VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);
INSERT INTO cliente VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);
INSERT INTO cliente VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);
INSERT INTO cliente VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);
INSERT INTO cliente VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);
INSERT INTO cliente VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);

INSERT INTO comercial VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);
INSERT INTO comercial VALUES(2, 'Juan', 'Gómez', 'López', 0.13);
INSERT INTO comercial VALUES(3, 'Diego','Flores', 'Salas', 0.11);
INSERT INTO comercial VALUES(4, 'Marta','Herrera', 'Gil', 0.14);
INSERT INTO comercial VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);
INSERT INTO comercial VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);
INSERT INTO comercial VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);
INSERT INTO comercial VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);

INSERT INTO pedido VALUES(1, 150.5, DATE'2017-10-05', 5, 2);
INSERT INTO pedido VALUES(2, 270.65, DATE'2016-09-10', 1, 5);
INSERT INTO pedido VALUES(3, 65.26, DATE'2017-10-05', 2, 1);
INSERT INTO pedido VALUES(4, 110.5, DATE'2016-08-17', 8, 3);
INSERT INTO pedido VALUES(5, 948.5, DATE'2017-09-10', 5, 2);
INSERT INTO pedido VALUES(6, 2400.6, DATE'2016-07-27', 7, 1);
INSERT INTO pedido VALUES(7, 5760, DATE'2015-09-10', 2, 1);
INSERT INTO pedido VALUES(8, 1983.43, DATE'2017-10-10', 4, 6);
INSERT INTO pedido VALUES(9, 2480.4, DATE'2016-10-10', 8, 3);
INSERT INTO pedido VALUES(10, 250.45, DATE'2015-06-27', 8, 2);
INSERT INTO pedido VALUES(11, 75.29, DATE'2016-08-17', 3, 7);
INSERT INTO pedido VALUES(12, 3045.6, DATE'2017-04-25', 2, 1);
INSERT INTO pedido VALUES(13, 545.75, DATE'2019-01-25', 6, 1);
INSERT INTO pedido VALUES(14, 145.82, DATE'2017-02-02', 6, 1);
INSERT INTO pedido VALUES(15, 370.85, DATE'2019-03-11', 1, 5);
INSERT INTO pedido VALUES(16, 2389.23, DATE'2019-03-11', 1, 5);

-- 1. Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado algún pedido. El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos.
SELECT DISTINCT cliente.id, nombre, apellido1, apellido2
FROM cliente, pedido 
WHERE cliente.id = pedido.id_cliente 
ORDER BY cliente.nombre ASC;

-- 2. Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
SELECT cliente.* 
FROM cliente 
LEFT JOIN pedido ON cliente.id = pedido.id_cliente 
WHERE pedido.id IS NULL;

-- 3. Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
SELECT comercial.* 
FROM comercial 
LEFT JOIN pedido ON comercial.id = pedido.id_comercial 
WHERE pedido.id IS NULL;

-- 4. Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe mostrar todos los datos de los pedidos y del cliente. El listado debe mostrar los datos de los clientes ordenados alfabéticamente.
SELECT c.*, p.*
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.nombre, c.apellido1, c.apellido2;

-- 5. Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado debe mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar los datos de los comerciales ordenados alfabéticamente.
SELECT co.*, p.*
FROM comercial co
JOIN pedido p ON co.id = p.id_comercial
ORDER BY co.nombre, co.apellido1, co.apellido2;

-- 6. Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con los datos de los comerciales asociados a cada pedido.
SELECT c.*, p.*, co.*
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
JOIN comercial co ON p.id_comercial = co.id;

-- 7. Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no han participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el nombre. En en listado deberá diferenciar de algún modo los clientes y los comerciales.
SELECT 'Cliente' AS tipo, c.nombre, c.apellido1, c.apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id_cliente IS NULL
UNION
SELECT 'Comercial' AS tipo, co.nombre, co.apellido1, co.apellido2
FROM comercial co
LEFT JOIN pedido p ON co.id = p.id_comercial
WHERE p.id_comercial IS NULL;

-- 8. Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya cantidad esté entre 300 € y 1000 €.
SELECT DISTINCT c.*
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
WHERE EXTRACT(YEAR FROM p.fecha) = 2017
AND p.total BETWEEN 300 AND 1000;

-- 9. Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado. Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.
SELECT co.*, p.*
FROM comercial co
LEFT JOIN pedido p ON co.id = p.id_comercial
ORDER BY co.apellido1, co.apellido2, co.nombre;

-- 10. Devuelve el nombre y los apellidos de todos los comerciales que ha participado en algún pedido realizado por María Santana Moreno.
SELECT DISTINCT co.nombre, co.apellido1, co.apellido2
FROM comercial co
JOIN pedido p ON co.id = p.id_comercial
JOIN cliente c ON p.id_cliente = c.id
WHERE c.nombre = 'María' AND c.apellido1 = 'Santana' AND c.apellido2 = 'Moreno';

-- 11. Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega.

-- 12. Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.