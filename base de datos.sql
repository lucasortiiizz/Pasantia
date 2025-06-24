-- Crear la base de datos
CREATE DATABASE bd_sistema_ventas;

-- Usar la base de datos
USE bd_sistema_ventas;

-- Crear tabla de usuarios
CREATE TABLE tb_usuario (
  idUsuario INT(11) AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  usuario VARCHAR(15) NOT NULL,
  password VARCHAR(15) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  estado INT(1) NOT NULL
);

-- Insertar usuario de prueba
INSERT INTO tb_usuario(nombre, apellido, usuario, password, telefono, estado)
VALUES ("Cinthya", "Pereira", "Cinthya", "12345", "0975581569", 1);

-- Ver usuarios
SELECT * FROM tb_usuario;

-- Verificación de login
SELECT usuario, password FROM tb_usuario WHERE usuario = "Cinthya" AND password = "12345";


-- Crear tabla de clientes
CREATE TABLE tb_cliente (
  idCliente INT(11) AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  cedula VARCHAR(15) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  direccion VARCHAR(100) NOT NULL,
  estado INT(1) NOT NULL
);


-- Crear tabla de categorías
CREATE TABLE tb_categoria (
  idCategoria INT(11) AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(200) NOT NULL,
  estado INT(1) NOT NULL
);

-- Insertar categorías de prueba
INSERT INTO tb_categoria (descripcion, estado) VALUES
('Pantalón', 1),
('Remera', 1),
('Abrigo', 1),
('Camisa', 1),
('Vestido', 1),
('Short', 1);

-- Ver categorías
SELECT * FROM tb_categoria;


-- Crear tabla de productos
CREATE TABLE tb_producto (
  idProducto INT(11) AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  cantidad INT(11) NOT NULL,
  precio DOUBLE(10,2) NOT NULL,
  descripcion VARCHAR(200) NOT NULL,
  porcentajeIva INT(2) NOT NULL,
  idCategoria INT(11) NOT NULL,
  estado INT(1) NOT NULL
);
select * from tb_producto;
select p.idProducto, p.nombre, p.cantidad, p.precio, p.porcentajeIva, c.descripcion, p.estado from tb_producto As p, tb_categoria As c where p.idCategoria = c.idCategoria;


-- Crear tabla cabecera de venta
CREATE TABLE tb_cabecera_venta (
  idCabeceraVenta INT(11) AUTO_INCREMENT PRIMARY KEY,
  idCliente INT(11) NOT NULL,
  valorPagar DOUBLE(10,2) NOT NULL,
  fechaVenta DATE NOT NULL,
  estado INT(1) NOT NULL
);


-- Crear tabla detalle de venta
CREATE TABLE tb_detalle_venta (
  idDetalleVenta INT(11) AUTO_INCREMENT PRIMARY KEY,
  idCabeceraVenta INT(11) NOT NULL,
  idProducto INT(11) NOT NULL,
  cantidad INT(11) NOT NULL,
  precioUnitario DOUBLE(10,2) NOT NULL,
  subtotal DOUBLE(10,2) NOT NULL,
  descuento DOUBLE(10,2) NOT NULL,
  iva DOUBLE(10,2) NOT NULL,
  totalPagar DOUBLE(10,2) NOT NULL,
  estado INT(1) NOT NULL
);

-- Mostrar todas las tablas de la base de datos
SHOW TABLES;
