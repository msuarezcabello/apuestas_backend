/**
 *
 */
package com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;

/**
 * @author msuarezc
 *
 */
@Entity
@Table( name = "Usuario")
public class UsuarioEntity {

	private String username;

	private String password;

	private PersonaEntity persona;

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
	public PersonaEntity getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersona")
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

}
