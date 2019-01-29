package com.devonfw.application.apuestas_backend.personamanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.Personamanagement;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase.UcFindPersona;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase.UcManagePersona;

/**
 * Implementation of component interface of personamanagement
 */
@Named
public class PersonamanagementImpl extends AbstractComponentFacade implements Personamanagement {

	@Inject
	private UcFindPersona ucFindPersona;

	@Inject
	private UcManagePersona ucManagePersona;

	@Override
	public PersonaEto findPersona(long id) {

		return this.ucFindPersona.findPersona(id);
	}

	@Override
	public Page<PersonaEto> findPersonas(PersonaSearchCriteriaTo criteria) {
		return this.ucFindPersona.findPersonas(criteria);
	}

	@Override
	public PersonaEto savePersona(PersonaEto persona) {

		return this.ucManagePersona.savePersona(persona);
	}

	@Override
	public boolean deletePersona(long id) {

		return this.ucManagePersona.deletePersona(id);
	}
}
