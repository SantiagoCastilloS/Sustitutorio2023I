
CREATE DATABASE negocioWeb;

CREATE TABLE cliente (
	id_cliente NUMERIC (4) PRIMARY KEY,
	dni CHAR (8),
	nombre_completo VARCHAR (100),
	mail VARCHAR (50),
	telefono CHAR (9)
);

CREATE TABLE proveedor (
	id_proveedor NUMERIC (4) PRIMARY KEY,
	ruc CHAR (11),
	razon_social VARCHAR (100),
	telefono_fijo VARCHAR (7)
);

CREATE TABLE producto (
	id_producto NUMERIC (4) PRIMARY KEY,
	nombre VARCHAR (50),
	descripcion VARCHAR (100),
	precio_venta NUMERIC (10,2),
	alto NUMERIC (10,2),
	ancho NUMERIC (10,2),
	profundidad NUMERIC (10,2),
	peso NUMERIC (10,2),	
	id_proveedor NUMERIC (4),
	FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor)
);

CREATE TABLE cupon (
	id_cupon NUMERIC (4) PRIMARY KEY,
	codigo CHAR (8),
	porcentaje_descuento NUMERIC (10,2),
	fecha_vencimiento CHAR (10),
	hora_vencimiento CHAR (5),
	id_producto NUMERIC (4),
	FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

CREATE TABLE compra (
	id_compra NUMERIC (4) PRIMARY KEY,
	cantidad NUMERIC (4),
	fecha_compra CHAR (10),
	hora_compra CHAR (5),
	forma_pago CHAR(1),
	estado CHAR(1),
	id_cupon NUMERIC (4),
	id_cliente NUMERIC (4),
	FOREIGN KEY (id_cupon) REFERENCES cupon (id_cupon),
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

INSERT INTO cliente VALUES (1,'44444441','Nestor Gonzales','ngonzales@gmail.com','999999991');
INSERT INTO cliente VALUES (2,'44444442','Juan Rivadeneira','jriva@gmail.com','999999992');
INSERT INTO cliente VALUES (3,'44444443','Jaime Aparca','japarca@gmail.com','999999993');
INSERT INTO cliente VALUES (4,'44444444','Jorge Nieto','jnieto@gmail.com','999999994');

INSERT INTO compra VALUES (1,1,'30/07/2023','23:59','C','A',1,1);
INSERT INTO compra VALUES (2,1,'30/07/2023','23:59','E','A',2,2);
INSERT INTO compra VALUES (3,2,'30/07/2023','23:59','C','A',3,3);
INSERT INTO compra VALUES (4,1,'30/07/2023','23:59','C','I',4,1);
INSERT INTO compra VALUES (5,1,'30/07/2023','23:59','C','A',5,1);
INSERT INTO compra VALUES (6,1,'30/07/2023','23:59','C','A',6,3);
INSERT INTO compra VALUES (7,2,'30/07/2023','23:59','C','A',1,2);

INSERT INTO cupon VALUES (1,'CUPO0001',0.94,'30/07/2023','23:59',1);
INSERT INTO cupon VALUES (2,'CUPO0002',0.59,'01/06/2023','23:59',2);
INSERT INTO cupon VALUES (3,'CUPO0003',0.49,'01/06/2023','23:59',3);
INSERT INTO cupon VALUES (4,'CUPO0004',0.68,'24/06/2023','23:59',4);
INSERT INTO cupon VALUES (5,'CUPO0005',0.53,'01/06/2023','23:59',5);
INSERT INTO cupon VALUES (6,'CUPO0006',0.10,'01/07/2023','23:59',1);

INSERT INTO producto VALUES (1,'Colchon','Colchon Black',1299.00,0.5,1.5,0.8,20.00,1);
INSERT INTO producto VALUES (2,'Armario','Armario de exterior',158.99,0.5,1.5,2.0,30.00,2);
INSERT INTO producto VALUES (3,'Maletas','Juego de 3 maletas',123.40,0.5,1.5,0.8,20.00,3);
INSERT INTO producto VALUES (4,'Auriculares','Inalambricos pares',35.43,0.1,0.2,0.1,0.50,1);
INSERT INTO producto VALUES (5,'Zapatero','Zapatero para armario',39.90,1.5,0.5,0.4,5.00,3);

INSERT INTO proveedor VALUES (1,'20100128056','SAGA FALABELLA SA','3333333');
INSERT INTO proveedor VALUES (2,'25324623452','TIENDAS POR DPTO SA','4444444');
INSERT INTO proveedor VALUES (3,'27654425243','TIENDAS PERUANAS SA','5555555');


-- 1)

INSERT INTO cupon VALUES (?,?,?,?,?,?);

-- 2)

UPDATE compra c SET c.estado = ?, c.forma_pago = ? WHERE c.id_cupon = (SELECT cu.id_cupon FROM cupon cu WHERE cu.codigo = ?) 
																	AND c.id_cliente = (SELECT cl.id_cliente FROM cliente cl WHERE cl.dni = ?);

-- 3) 

SELECT
	cl.dni,
	cl.nombre_completo,
	com.cantidad * (1 - cup.porcentaje_descuento) * p.precio_venta AS precioFinal,
	com.cantidad,
	com.fecha_compra,
	com.forma_pago,
	com.estado,
	cup.codigo,
	cup.porcentaje_descuento,
	cup.fecha_vencimiento,
	p.precio_venta,
	pr.ruc,
	pr.razon_social
FROM cliente cl
LEFT JOIN compra com ON (com.id_cliente = cl.id_cliente)
LEFT JOIN cupon cup ON (cup.id_cupon = com.id_cupon)
LEFT JOIN producto p ON (p.id_producto = cup.id_producto)
LEFT JOIN proveedor pr ON (pr.id_proveedor = p.id_proveedor)
WHERE (com.estado = 'A' OR com.estado IS NULL) AND (com.forma_pago = 'C' OR com.forma_pago IS NULL)
ORDER BY cl.dni ASC, precioFinal DESC;