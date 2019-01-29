package com.devonfw.application.apuestas_backend.mejoramanager.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;

public interface Mejora extends ApplicationEntity {

	/**
	 * @return descripcionId
	 */

	public String getDescripcion();

	/**
	 * @param descripcion setter for descripcion attribute
	 */

	public void setDescripcion(String descripcion);

	/**
	 * getter for tipoMejoraId attribute
	 * 
	 * @return tipoMejoraId
	 */

	public Long getTipoMejoraId();

	/**
	 * @param tipoMejora setter for tipoMejora attribute
	 */

	public void setTipoMejoraId(Long tipoMejoraId);

}
