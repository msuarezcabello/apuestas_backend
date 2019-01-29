package com.devonfw.application.apuestas_backend.usuariomanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.base.usecase.AbstractUsuarioUc;

/**
 * Use case implementation for searching, filtering and getting Usuarios
 */
@Named
@Validated
@Transactional
public class UcFindUsuarioImpl extends AbstractUsuarioUc implements UcFindUsuario {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindUsuarioImpl.class);

	@Override
	public UsuarioCto findUsuarioCto(long id) {
		LOG.debug("Get UsuarioCto with id {} from database.", id);
		UsuarioEntity entity = getUsuarioRepository().find(id);
		UsuarioCto cto = new UsuarioCto();
		cto.setUsuario(getBeanMapper().map(entity, UsuarioEto.class));
		cto.setPersona(getBeanMapper().map(entity.getPersona(), PersonaEto.class));

		return cto;
	}

	@Override
	public Page<UsuarioCto> findUsuarioCtos(UsuarioSearchCriteriaTo criteria) {

		Page<UsuarioEntity> usuarios = getUsuarioRepository().findByCriteria(criteria);
		List<UsuarioCto> ctos = new ArrayList<>();
		for (UsuarioEntity entity : usuarios.getContent()) {
			UsuarioCto cto = new UsuarioCto();
			cto.setUsuario(getBeanMapper().map(entity, UsuarioEto.class));
			cto.setPersona(getBeanMapper().map(entity.getPersona(), PersonaEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, usuarios.getTotalElements());
	}
}
