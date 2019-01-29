package com.devonfw.application.apuestas_backend.personamanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase.UcManagePersona;
import com.devonfw.application.apuestas_backend.personamanagement.logic.base.usecase.AbstractPersonaUc;

/**
 * Use case implementation for modifying and deleting Personas
 */
@Named
@Validated
@Transactional
public class UcManagePersonaImpl extends AbstractPersonaUc implements UcManagePersona {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManagePersonaImpl.class);

	@Override
	public boolean deletePersona(long personaId) {

		PersonaEntity persona = getPersonaRepository().find(personaId);
		getPersonaRepository().delete(persona);
		LOG.debug("The persona with id '{}' has been deleted.", personaId);
		return true;
	}

	@Override
	public PersonaEto savePersona(PersonaEto persona) {

		Objects.requireNonNull(persona, "persona");

		PersonaEntity personaEntity = getBeanMapper().map(persona, PersonaEntity.class);

		// initialize, validate personaEntity here if necessary
		PersonaEntity resultEntity = getPersonaRepository().save(personaEntity);
		LOG.debug("Persona with id '{}' has been created.", resultEntity.getId());
		return getBeanMapper().map(resultEntity, PersonaEto.class);
	}
}
