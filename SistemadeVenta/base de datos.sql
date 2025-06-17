-- crear nuestra base de datos
create database bd_sistema_ventas;
-- usamos la base de datos
use bd_sistema_ventas;

-- crear tabla usuarios
create table tb_usuario(
idUsuario int (11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
usuario varchar(15) not null,
password varchar(15) not null,
telefono varchar(15) not null,
estado int(1) not null
);

insert into tb_usuario(nombre, apellido, usuario, password, telefono, estado)
Values("Cinthya", "Pereira", "Cinthya", "12345", "0975581569", 1);

select * from tb_usuario;

select usuario , password from tb_usuario where usuario = "Cinthya" and password = "12345" ;

-- crear tabla cliente
create table tb_cliente(
idCliente int (11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
cedula varchar(15) not null,
telefono varchar(15) not null,
direccion varchar(100) not null,
estado int(1) not null
);

-- crear tabla categoria
create table tb_categoria(
idCategoria int (11) auto_increment primary key,
descripcion varchar(200) not null,
estado int(1) not null
);

-- crear tabla producto
create table tb_producto(
idProducto int (11) auto_increment primary key,
nombre varchar(100) not null,
cantidad int(11) not null,
precio double(10,2) not null,
descripcion varchar(200) not null,
porcentajeIva int(2) not null,
idCategoria int(11) not null,
estado int(1) not null
);

-- crear tabla cabecera de venta
create table tb_cabecera_venta(
idCabeceraVenta int (11) auto_increment primary key,
idCliente int(11) not null,
valorPagar double(10,2) not null,
fechaVenta date not null,
estado int(1) not null
);

-- crear tabla detalle de venta
create table tb_detalle_venta(
idDetalleVenta int (11) auto_increment primary key,
idCabeceraVenta int (11) not null,
idProducto int (11) not null,
cantidad int(11) not null,
precioUnitario double(10,2) not null,
subtotal double(10,2) not null,
descuento double(10,2) not null,
iva double(10,2) not null,
totalPagar double(10,2) not null,
estado int(1) not null
);

-- mostrar todas las tablas de mi base de datos
show tables;