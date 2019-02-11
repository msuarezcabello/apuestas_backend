package com.devonfw.application.apuestas_backend.registermanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;

public interface Register extends ApplicationEntity {

	/**
	 * getter for personaId attribute
	 * 
	 * @return personaId
	 */

	public Long getPersonaId();

	/**
	 * @param persona setter for persona attribute
	 */

	public void setPersonaId(Long personaId);

	/**
	 * getter for usuarioId attribute
	 * 
	 * @return usuarioId
	 */

	public Long getUsuarioId();

	/**
	 * @param usuario setter for usuario attribute
	 */

	public void setUsuarioId(Long usuarioId);

}
