create table avion (
 id int(11) not null auto_increment,
 matricula varchar(10) unique,
 pasajeros int not null,
 primary key (id)
);

create table destino (
 id int(11) not null auto_increment,
 ciudad_origen varchar(30) not null,
 ciudad_destino varchar(30) not null,
 valor_base int not null,
 primary key (id)
);

create table vuelo (
 id int(11) not null auto_increment,
 id_avion int not null,
 id_destino int not null,
 fecha datetime not null,
 duracion int not null,
 primary key (id),
 foreign key (id_avion) references avion(id),
 foreign key (id_destino) references destino(id)
);

create table reserva (
 id int(11) not null auto_increment,
 id_vuelo int not null,
 tipo_identificacion varchar(2) not null,
 numero_identificacion varchar(20) not null,
 pasajeros int not null,
 valor_total int not null,
 activa boolean not null default true,
 token varchar(100) not null,
 primary key (id),
 foreign key (id_vuelo) references vuelo(id)
);
