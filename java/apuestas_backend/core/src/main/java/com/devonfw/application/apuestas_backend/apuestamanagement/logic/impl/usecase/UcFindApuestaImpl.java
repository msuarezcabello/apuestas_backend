package com.devonfw.application.apuestas_backend.apuestamanagement.logic.impl.usecase;

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

import com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api.ApuestaEntity;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaEto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase.UcFindApuesta;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.base.usecase.AbstractApuestaUc;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;

/**
 * Use case implementation for searching, filtering and getting Apuestas
 */
@Named
@Validated
@Transactional
public class UcFindApuestaImpl extends AbstractApuestaUc implements UcFindApuesta {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindApuestaImpl.class);

	@Override
	public ApuestaCto findApuestaCto(long id) {
		LOG.debug("Get ApuestaCto with id {} from database.", id);
		ApuestaEntity entity = getApuestaRepository().find(id);
		ApuestaCto cto = new ApuestaCto();
		cto.setApuesta(getBeanMapper().map(entity, ApuestaEto.class));
		cto.setUsuario(getBeanMapper().map(entity.getUsuario(), UsuarioEto.class));

		return cto;
	}

	@Override
	public Page<ApuestaCto> findApuestaCtos(ApuestaSearchCriteriaTo criteria) {

		Page<ApuestaEntity> apuestas = getApuestaRepository().findByCriteria(criteria);
		List<ApuestaCto> ctos = new ArrayList<>();
		for (ApuestaEntity entity : apuestas.getContent()) {
			ApuestaCto cto = new ApuestaCto();
			cto.setApuesta(getBeanMapper().map(entity, ApuestaEto.class));
			cto.setUsuario(getBeanMapper().map(entity.getUsuario(), UsuarioEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, apuestas.getTotalElements());
	}
}
