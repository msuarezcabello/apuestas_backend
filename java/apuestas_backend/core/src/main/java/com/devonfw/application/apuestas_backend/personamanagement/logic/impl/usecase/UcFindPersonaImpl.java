package com.devonfw.application.apuestas_backend.personamanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase.UcFindPersona;
import com.devonfw.application.apuestas_backend.personamanagement.logic.base.usecase.AbstractPersonaUc;

/**
 * Use case implementation for searching, filtering and getting Personas
 */
@Named
@Validated
@Transactional
public class UcFindPersonaImpl extends AbstractPersonaUc implements UcFindPersona {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindPersonaImpl.class);

	@Override
	public PersonaEto findPersona(long id) {
		LOG.debug("Get Persona with id {} from database.", id);
		Optional<PersonaEntity> foundEntity = getPersonaRepository().findById(id);
		if (foundEntity.isPresent())
			return getBeanMapper().map(foundEntity.get(), PersonaEto.class);
		else
			return null;
	}

	@Override
	public Page<PersonaEto> findPersonas(PersonaSearchCriteriaTo criteria) {
		Page<PersonaEntity> personas = getPersonaRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(personas, PersonaEto.class);
	}

}
