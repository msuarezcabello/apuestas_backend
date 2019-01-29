package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.usuariomejoramanagement.common.api.UsuarioMejora}s.
 */
public class UsuarioMejoraSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Long usuarioId;

	private Long mejoraId;

	/**
	 * getter for usuarioId attribute
	 * 
	 * @return usuarioId
	 */

	public Long getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuario setter for usuario attribute
	 */

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * getter for mejoraId attribute
	 * 
	 * @return mejoraId
	 */

	public Long getMejoraId() {
		return mejoraId;
	}

	/**
	 * @param mejora setter for mejora attribute
	 */

	public void setMejoraId(Long mejoraId) {
		this.mejoraId = mejoraId;
	}

}
