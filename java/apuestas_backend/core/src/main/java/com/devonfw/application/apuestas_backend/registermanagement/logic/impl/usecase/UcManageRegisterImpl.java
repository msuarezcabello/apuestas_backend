package com.devonfw.application.apuestas_backend.registermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.personamanagement.common.api.Persona;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.Personamanagement;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.Registermanagement;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterCto;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.usecase.UcManageRegister;
import com.devonfw.application.apuestas_backend.registermanagement.logic.base.usecase.AbstractRegisterUc;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.Usuariomanagement;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

@Named
@Validated
@Transactional
public class UcManageRegisterImpl extends AbstractRegisterUc implements UcManageRegister {

	@Inject
	private Usuariomanagement usuariomanagement;

	@Inject
	private Personamanagement personamanagement;

	@Override
	public RegisterCto saveRegisterCto(RegisterCto registerCto) {
		// Check nulls
		Objects.requireNonNull(registerCto);
		Objects.requireNonNull(registerCto.getPersona());
		Objects.requireNonNull(registerCto.getUsuario());

		// Check if Persona or Usuario already exists
		try {
			checkIfPersonaExists(registerCto.getPersona());
		} catch(IllegalArgumentException e) {
			return null;
		}

		try {
			checkIfUsuarioExists(registerCto.getUsuario());
		} catch(IllegalArgumentException e) {
			return null;
		}

		// If everything is right, save
		registerCto.setPersona(getPersonamanagement().savePersona(registerCto.getPersona()));

		registerCto.getUsuario().setPersonaId(registerCto.getPersona().getId());
		registerCto.setUsuario(getUsuariomanagement().saveUsuario(registerCto.getUsuario()));

		return registerCto;
	}

	public Usuariomanagement getUsuariomanagement() {
		return usuariomanagement;
	}

	public Personamanagement getPersonamanagement() {
		return personamanagement;
	}

	private void checkIfPersonaExists(PersonaEto personaEto) {
		PersonaSearchCriteriaTo personaSearchCriteriaTo = new PersonaSearchCriteriaTo();
		personaSearchCriteriaTo.setEmail(personaEto.getEmail());
		personaSearchCriteriaTo.setPageable(PageRequest.of(0, 100));
		if (getPersonamanagement().findPersonas(personaSearchCriteriaTo).hasContent()) {
			throw new IllegalArgumentException("La persona ya existe");
		}
	}

	private void checkIfUsuarioExists(UsuarioEto usuarioEto) {
		UsuarioSearchCriteriaTo usuarioSearchCriteriaTo = new UsuarioSearchCriteriaTo();
		usuarioSearchCriteriaTo.setUsername(usuarioEto.getUsername());
		usuarioSearchCriteriaTo.setPageable(PageRequest.of(0, 100));
		if (getUsuariomanagement().findUsuarioCtos(usuarioSearchCriteriaTo).hasContent()) {
			throw new IllegalArgumentException("El nombre de usuario ya existe");
		}
	}
}
