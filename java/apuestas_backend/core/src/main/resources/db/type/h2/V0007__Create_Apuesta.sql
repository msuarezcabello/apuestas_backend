create table Apuesta(
	id bigint not null auto_increment,
	modificationCounter integer not null,

	ladoApostado bool not null,
	resultado bool,
	fecha timestamp as current_timestamp not null,
	valorApostado double not null,
	valorGanado double not null,
	idUsuario bigint not null,
	constraint Pk_Apuesta primary key (id),
	constraint Fk_Apuesta_Usuario foreign key(idUsuario) references Usuario (id)
);