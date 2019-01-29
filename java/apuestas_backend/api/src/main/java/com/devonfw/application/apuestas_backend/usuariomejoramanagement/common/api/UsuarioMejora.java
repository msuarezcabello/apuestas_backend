package com.devonfw.application.apuestas_backend.usuariomejoramanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;

public interface UsuarioMejora extends ApplicationEntity {

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

	/**
	 * getter for mejoraId attribute
	 * 
	 * @return mejoraId
	 */

	public Long getMejoraId();

	/**
	 * @param mejora setter for mejora attribute
	 */

	public void setMejoraId(Long mejoraId);

}
