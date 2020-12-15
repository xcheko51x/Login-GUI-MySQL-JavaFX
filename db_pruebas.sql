create database pruebas;

use pruebas;

create table usuarios(
	idUsuario int primary key auto_increment,
    nombre varchar(50) not null,
    usuario varchar(20) not null,
    contrasena varchar(10) not null
);