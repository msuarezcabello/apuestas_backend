create table Persona(
	id bigint not null auto_increment,
	modificationCounter integer not null,
	nombre varchar(255) not null,
	fechaNacimiento timestamp not null,
	email varchar(255) not null,
	constraint Pk_Persona primary key (id)
);