package com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api;

import javax.persistence.*;

import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;

@Entity
@Table(name = "Usuario_Mejora")
public class UsuarioMejoraEntity {
	private UsuarioEntity usuario;

	private MejoraEntity mejora;
}
