create table TipoMejora(
	id bigint not null auto_increment,
	modificationCounter integer not null,
	descripcion varchar(255) not null
	constraint Pk_TipoMejora primary key (id)
);