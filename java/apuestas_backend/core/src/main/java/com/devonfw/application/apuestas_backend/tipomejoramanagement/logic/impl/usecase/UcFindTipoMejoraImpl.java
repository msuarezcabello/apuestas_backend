package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.TipoMejoraEntity;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase.UcFindTipoMejora;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.base.usecase.AbstractTipoMejoraUc;

/**
 * Use case implementation for searching, filtering and getting TipoMejoras
 */
@Named
@Validated
@Transactional
public class UcFindTipoMejoraImpl extends AbstractTipoMejoraUc implements UcFindTipoMejora {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindTipoMejoraImpl.class);

	@Override
	public TipoMejoraEto findTipoMejora(long id) {
		LOG.debug("Get TipoMejora with id {} from database.", id);
		Optional<TipoMejoraEntity> foundEntity = getTipoMejoraRepository().findById(id);
		if (foundEntity.isPresent())
			return getBeanMapper().map(foundEntity.get(), TipoMejoraEto.class);
		else
			return null;
	}

	@Override
	public Page<TipoMejoraEto> findTipoMejoras(TipoMejoraSearchCriteriaTo criteria) {
		Page<TipoMejoraEntity> tipomejoras = getTipoMejoraRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(tipomejoras, TipoMejoraEto.class);
	}

}
