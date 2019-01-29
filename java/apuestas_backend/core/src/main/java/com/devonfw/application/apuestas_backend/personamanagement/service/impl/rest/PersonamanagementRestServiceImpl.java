package com.devonfw.application.apuestas_backend.personamanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.Personamanagement;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.personamanagement.service.api.rest.PersonamanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Personamanagement}.
 */
@Named("PersonamanagementRestService")
public class PersonamanagementRestServiceImpl implements PersonamanagementRestService {

	@Inject
	private Personamanagement personamanagement;

	@Override
	public PersonaEto getPersona(long id) {
		return this.personamanagement.findPersona(id);
	}

	@Override
	public PersonaEto savePersona(PersonaEto persona) {
		return this.personamanagement.savePersona(persona);
	}

	@Override
	public void deletePersona(long id) {
		this.personamanagement.deletePersona(id);
	}

	@Override
	public Page<PersonaEto> findPersonas(PersonaSearchCriteriaTo searchCriteriaTo) {
		return this.personamanagement.findPersonas(searchCriteriaTo);
	}
}