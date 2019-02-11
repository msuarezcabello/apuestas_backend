package com.devonfw.application.apuestas_backend.registermanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.registermanagement.common.api.Register}s.
 */
public class RegisterSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Long personaId;

	private Long usuarioId;

	/**
	 * getter for personaId attribute
	 *
	 * @return personaId
	 */
	public Long getPersonaId() {
		return personaId;
	}

	/**
	 * @param persona setter for persona attribute
	 */
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

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

}
