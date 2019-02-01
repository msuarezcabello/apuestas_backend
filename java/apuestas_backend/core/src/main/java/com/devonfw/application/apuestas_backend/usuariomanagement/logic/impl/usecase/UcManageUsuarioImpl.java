/**
 *
 */
package com.devonfw.application.apuestas_backend.usuariomanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.Personamanagement;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase.UcFindPersona;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcManageUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.base.usecase.AbstractUsuarioUc;
/**
 * @author msuarezc
 *
 */
@Named
@Validated
@Transactional
public class UcManageUsuarioImpl extends AbstractUsuarioUc implements UcManageUsuario{

	@Inject
	private UcFindPersona ucFindPersona;

	@Inject
	private UcFindUsuario ucFindUsuario;

	@Inject
	private Personamanagement personamanagement;

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageUsuarioImpl.class);

	@Override
	public Boolean deleteUsuario(long usuarioId) {

		return null;
	}

	@Override
	public UsuarioEto saveUsuario(UsuarioEto usuarioEto) {

		Objects.requireNonNull(usuarioEto, "UsuarioEto usuarioEto null");

		UsuarioEntity usuarioEntity = getBeanMapper().map(usuarioEto, UsuarioEntity.class);

		long personaId = usuarioEntity.getPersonaId();
		UsuarioSearchCriteriaTo usuarioSearchCriteriaTo = new UsuarioSearchCriteriaTo();
		usuarioSearchCriteriaTo.setPersonaId(personaId);

		Pageable pageable = PageRequest.of(0, 100);
		usuarioSearchCriteriaTo.setPageable(pageable);

		// save the Usuario
		UsuarioEntity usuarioEntitySaved = getUsuarioRepository().save(usuarioEntity);
		LOG.debug("The usuario with id '{}' has been saved.", usuarioEntitySaved.getId());


		return getBeanMapper().map(usuarioEntity, UsuarioEto.class);
	}

	public Personamanagement getPersonamanagement() {
		return this.personamanagement;
	}
}
