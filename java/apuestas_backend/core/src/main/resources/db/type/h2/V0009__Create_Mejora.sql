create table Mejora(
	id bigint not null auto_increment,
	modificationCounter integer not null,
	descripcion varchar(255) not null,
	idTipoMejora bigint not null,
	constraint Pk_Mejora primary key (id),
	constraint Fk_Mejora_TipoMejora foreign key(idTipoMejora) references TipoMejora(id)
);