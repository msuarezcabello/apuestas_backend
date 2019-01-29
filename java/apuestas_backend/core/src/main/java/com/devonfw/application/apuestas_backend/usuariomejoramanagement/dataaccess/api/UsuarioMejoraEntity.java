package com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api;

import javax.persistence.*;

@Entity
@Table(name = "Usuario_Mejora")
public class UsuarioMejoraEntity {
	private Usuario usuario;

	private Mejora mejora;
}
