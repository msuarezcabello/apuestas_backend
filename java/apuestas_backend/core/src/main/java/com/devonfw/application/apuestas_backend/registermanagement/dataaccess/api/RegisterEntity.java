package com.devonfw.application.apuestas_backend.registermanagement.dataaccess.api;

import javax.persistence.Transient;

import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.registermanagement.common.api.Register;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;

public class RegisterEntity extends ApplicationPersistenceEntity implements Register {

	private PersonaEntity persona;

	private UsuarioEntity usuario;

	private static final long serialVersionUID = 1L;

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Override
	@Transient
	public Long getPersonaId() {

		if (this.persona == null) {
			return null;
		}
		return this.persona.getId();
	}

	@Override
	public void setPersonaId(Long personaId) {

		if (personaId == null) {
			this.persona = null;
		} else {
			PersonaEntity personaEntity = new PersonaEntity();
			personaEntity.setId(personaId);
			this.persona = personaEntity;
		}
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

}
