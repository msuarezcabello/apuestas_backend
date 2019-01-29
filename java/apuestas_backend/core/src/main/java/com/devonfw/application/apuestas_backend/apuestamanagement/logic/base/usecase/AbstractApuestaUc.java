package com.devonfw.application.apuestas_backend.apuestamanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api.repo.ApuestaRepository;
import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;

/**
 * Abstract use case for Apuestas, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractApuestaUc extends AbstractUc {

	/** @see #getApuestaRepository() */
	@Inject
	private ApuestaRepository apuestaRepository;

	/**
	 * Returns the field 'apuestaRepository'.
	 * 
	 * @return the {@link ApuestaRepository} instance.
	 */
	public ApuestaRepository getApuestaRepository() {

		return this.apuestaRepository;
	}

}
