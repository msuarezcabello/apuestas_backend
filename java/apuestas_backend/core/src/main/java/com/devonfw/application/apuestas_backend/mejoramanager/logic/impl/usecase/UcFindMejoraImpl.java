package com.devonfw.application.apuestas_backend.mejoramanager.logic.impl.usecase;

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

import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.usecase.UcFindMejora;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.base.usecase.AbstractMejoraUc;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;

/**
 * Use case implementation for searching, filtering and getting Mejoras
 */
@Named
@Validated
@Transactional
public class UcFindMejoraImpl extends AbstractMejoraUc implements UcFindMejora {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindMejoraImpl.class);

	@Override
	public MejoraCto findMejoraCto(long id) {
		LOG.debug("Get MejoraCto with id {} from database.", id);
		MejoraEntity entity = getMejoraRepository().find(id);
		MejoraCto cto = new MejoraCto();
		cto.setMejora(getBeanMapper().map(entity, MejoraEto.class));
		cto.setTipoMejora(getBeanMapper().map(entity.getTipoMejora(), TipoMejoraEto.class));

		return cto;
	}

	@Override
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo criteria) {

		Page<MejoraEntity> mejoras = getMejoraRepository().findByCriteria(criteria);
		List<MejoraCto> ctos = new ArrayList<>();
		for (MejoraEntity entity : mejoras.getContent()) {
			MejoraCto cto = new MejoraCto();
			cto.setMejora(getBeanMapper().map(entity, MejoraEto.class));
			cto.setTipoMejora(getBeanMapper().map(entity.getTipoMejora(), TipoMejoraEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, mejoras.getTotalElements());
	}
}
