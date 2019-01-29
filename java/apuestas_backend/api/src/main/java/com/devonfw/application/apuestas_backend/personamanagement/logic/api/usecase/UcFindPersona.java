package com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;

public interface UcFindPersona {

	/**
	 * Returns a Persona by its id 'id'.
	 *
	 * @param id The id 'id' of the Persona.
	 * @return The {@link PersonaEto} with id 'id'
	 */
	PersonaEto findPersona(long id);

	/**
	 * Returns a paginated list of Personas matching the search criteria.
	 *
	 * @param criteria the {@link PersonaSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link PersonaEto}s.
	 */
	Page<PersonaEto> findPersonas(PersonaSearchCriteriaTo criteria);

}
