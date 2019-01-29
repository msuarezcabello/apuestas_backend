package com.devonfw.application.apuestas_backend.tipomejoramanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;

public interface TipoMejora extends ApplicationEntity {

	/**
	 * @return descripcionId
	 */

	public String getDescripcion();

	/**
	 * @param descripcion setter for descripcion attribute
	 */

	public void setDescripcion(String descripcion);

}
