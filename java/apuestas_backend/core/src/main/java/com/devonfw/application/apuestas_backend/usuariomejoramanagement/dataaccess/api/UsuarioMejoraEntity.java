package com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api;

import javax.persistence.*;

import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;

@Entity
@Table(name = "Usuario_Mejora")
public class UsuarioMejoraEntity {
	private UsuarioEntity usuario;

	private MejoraEntity mejora;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idMejora")
	public MejoraEntity getMejora() {
		return mejora;
	}

	public void setMejora(MejoraEntity mejora) {
		this.mejora = mejora;
	}
}
