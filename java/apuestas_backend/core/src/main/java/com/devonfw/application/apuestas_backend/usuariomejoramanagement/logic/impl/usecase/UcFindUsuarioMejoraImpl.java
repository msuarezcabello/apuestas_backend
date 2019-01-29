package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.impl.usecase;

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

import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api.UsuarioMejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraCto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraEto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.usecase.UcFindUsuarioMejora;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.base.usecase.AbstractUsuarioMejoraUc;

/**
 * Use case implementation for searching, filtering and getting UsuarioMejoras
 */
@Named
@Validated
@Transactional
public class UcFindUsuarioMejoraImpl extends AbstractUsuarioMejoraUc implements UcFindUsuarioMejora {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindUsuarioMejoraImpl.class);

	@Override
	public UsuarioMejoraCto findUsuarioMejoraCto(long id) {
		LOG.debug("Get UsuarioMejoraCto with id {} from database.", id);
		UsuarioMejoraEntity entity = getUsuarioMejoraRepository().find(id);
		UsuarioMejoraCto cto = new UsuarioMejoraCto();
		cto.setUsuarioMejora(getBeanMapper().map(entity, UsuarioMejoraEto.class));
		cto.setUsuario(getBeanMapper().map(entity.getUsuario(), UsuarioEto.class));
		cto.setMejora(getBeanMapper().map(entity.getMejora(), MejoraEto.class));

		return cto;
	}

	@Override
	public Page<UsuarioMejoraCto> findUsuarioMejoraCtos(UsuarioMejoraSearchCriteriaTo criteria) {

		Page<UsuarioMejoraEntity> usuariomejoras = getUsuarioMejoraRepository().findByCriteria(criteria);
		List<UsuarioMejoraCto> ctos = new ArrayList<>();
		for (UsuarioMejoraEntity entity : usuariomejoras.getContent()) {
			UsuarioMejoraCto cto = new UsuarioMejoraCto();
			cto.setUsuarioMejora(getBeanMapper().map(entity, UsuarioMejoraEto.class));
			cto.setUsuario(getBeanMapper().map(entity.getUsuario(), UsuarioEto.class));
			cto.setMejora(getBeanMapper().map(entity.getMejora(), MejoraEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, usuariomejoras.getTotalElements());
	}
}
