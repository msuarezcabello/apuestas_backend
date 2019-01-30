/**
 */
package com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.common.api.Usuario;

/**
 * @author msuarezc
 */
@Entity
@Table(name = "Usuario")
public class UsuarioEntity extends ApplicationPersistenceEntity implements Usuario {

	private String username;

	private String password;

	private PersonaEntity persona;

	private static final long serialVersionUID = 1L;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the persona
	 */
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersona")
	public PersonaEntity getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
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

}
