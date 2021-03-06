package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.impl.usecase;

import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcFindMejora;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.TipoMejoraEntity;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase.UcManageTipoMejora;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.base.usecase.AbstractTipoMejoraUc;

/**
 * Use case implementation for modifying and deleting TipoMejoras
 */
@Named
@Validated
@Transactional
public class UcManageTipoMejoraImpl extends AbstractTipoMejoraUc implements UcManageTipoMejora {

	private UcFindMejora ucFindMejora;

	private MejoraSearchCriteriaTo mejoraSearchCriteriaTo;

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageTipoMejoraImpl.class);

	@Override
	public boolean deleteTipoMejora(long tipoMejoraId) {

		List<MejoraCto> listMejoraCtos = dependenciesById(tipoMejoraId);
		if(!listMejoraCtos.isEmpty()) {
//			for (MejoraCto mejoraCto : listMejoraCtos) {
//
//			}
			return false;
		}
		else {
			TipoMejoraEntity tipoMejora = getTipoMejoraRepository().find(tipoMejoraId);
			getTipoMejoraRepository().delete(tipoMejora);
			LOG.debug("The tipoMejora with id '{}' has been deleted.", tipoMejoraId);
			return true;
		}
	}

	public List<MejoraCto> dependenciesById(long tipoMejoraId) {
		return getUcFindMejora().findMejoraCtos(mejoraSearchCriteriaTo).getContent();
	}

	public UcFindMejora getUcFindMejora() {
		return ucFindMejora;
	}

	@Override
	public TipoMejoraEto saveTipoMejora(TipoMejoraEto tipoMejora) {

		Objects.requireNonNull(tipoMejora, "tipoMejora");

		TipoMejoraEntity tipoMejoraEntity = getBeanMapper().map(tipoMejora, TipoMejoraEntity.class);

		// initialize, validate tipoMejoraEntity here if necessary
		TipoMejoraEntity resultEntity = getTipoMejoraRepository().save(tipoMejoraEntity);
		LOG.debug("TipoMejora with id '{}' has been created.", resultEntity.getId());
		return getBeanMapper().map(resultEntity, TipoMejoraEto.class);
	}
}
