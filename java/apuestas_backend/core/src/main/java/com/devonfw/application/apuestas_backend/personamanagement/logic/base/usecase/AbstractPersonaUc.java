package com.devonfw.application.apuestas_backend.personamanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;
import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.repo.PersonaRepository;

/**
 * Abstract use case for Personas, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractPersonaUc extends AbstractUc {

	/** @see #getPersonaRepository() */
	@Inject
	private PersonaRepository personaRepository;

	/**
	 * Returns the field 'personaRepository'.
	 * 
	 * @return the {@link PersonaRepository} instance.
	 */
	public PersonaRepository getPersonaRepository() {

		return this.personaRepository;
	}

}
