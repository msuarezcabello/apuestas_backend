create table Usuario(
	id bigint not null auto_increment,
	modificationCounter integer not null,
	username varchar(255) not null,
	password varchar(255) not null,
	idPersona bigint NOT NULL,
	constraint Pk_Usuario primary key(id),
	constraint Fk_Usuario_Persona foreign key (idPersona) references Persona(id)
);