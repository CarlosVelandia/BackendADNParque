create table usuario (
    id int(11) not null auto_increment,
    nombre varchar(100) not null,
    clave varchar(45) not null,
    fecha_creacion date null,
    primary key (id)
);
create table parque (
    id int(11) not null auto_increment,
    nombre varchar(100) not null,
    codigo varchar(45) not null,
    direccion varchar(45) not null,
    telefono varchar(20) not null,
    primary key (id)
);

create table tiquete (
    id int(11) not null auto_increment,
    usuario_id int(11) not null,
    parque_id int(11) not null,
    fecha_compra date not null,
    valor double not null,
    primary key (id),
    foreign key (usuario_id) REFERENCES usuario(id),
    foreign key (parque_id) REFERENCES parque(id)
)
