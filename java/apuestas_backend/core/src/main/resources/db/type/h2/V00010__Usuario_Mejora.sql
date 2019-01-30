create table Usuario_Mejora(
	id bigint not null auto_increment,
	modificationCounter integer not null,
	idUsuario bigint not null,
	idMejora bigint not null,
	constraint Pk_Usuario_Mejora primary key (id),
	constraint Fk_Usuario_Mejora_Usuario foreign key(idUsuario) references Usuario (id),
	constraint Fk_Usuario_Mejora_Mejora foreign key(idMejora) references Mejora (id)
);