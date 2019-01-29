package com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.common.api.UsuarioMejora;

@Entity
@Table(name = "Usuario_Mejora")
public class UsuarioMejoraEntity extends ApplicationPersistenceEntity implements UsuarioMejora {

	private UsuarioEntity usuario;

	private MejoraEntity mejora;

	private static final long serialVersionUID = 1L;

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

	@Override
	@Transient
	public Long getUsuarioId() {

		if (this.usuario == null) {
			return null;
		}
		return this.usuario.getId();
	}

	@Override
	public void setUsuarioId(Long usuarioId) {

		if (usuarioId == null) {
			this.usuario = null;
		} else {
			UsuarioEntity usuarioEntity = new UsuarioEntity();
			usuarioEntity.setId(usuarioId);
			this.usuario = usuarioEntity;
		}
	}

	@Override
	@Transient
	public Long getMejoraId() {

		if (this.mejora == null) {
			return null;
		}
		return this.mejora.getId();
	}

	@Override
	public void setMejoraId(Long mejoraId) {

		if (mejoraId == null) {
			this.mejora = null;
		} else {
			MejoraEntity mejoraEntity = new MejoraEntity();
			mejoraEntity.setId(mejoraId);
			this.mejora = mejoraEntity;
		}
	}

}
