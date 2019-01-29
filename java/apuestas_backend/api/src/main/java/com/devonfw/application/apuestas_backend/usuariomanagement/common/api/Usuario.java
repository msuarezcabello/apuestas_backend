package com.devonfw.application.apuestas_backend.usuariomanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;

public interface Usuario extends ApplicationEntity {

	/**
	 * @return usernameId
	 */

	public String getUsername();

	/**
	 * @param username setter for username attribute
	 */

	public void setUsername(String username);

	/**
	 * @return passwordId
	 */

	public String getPassword();

	/**
	 * @param password setter for password attribute
	 */

	public void setPassword(String password);

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

}
