package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.Tipomejoramanagement;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase.UcFindTipoMejora;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase.UcManageTipoMejora;

/**
 * Implementation of component interface of tipomejoramanagement
 */
@Named
public class TipomejoramanagementImpl extends AbstractComponentFacade implements Tipomejoramanagement {

	@Inject
	private UcFindTipoMejora ucFindTipoMejora;

	@Inject
	private UcManageTipoMejora ucManageTipoMejora;

	@Override
	public TipoMejoraEto findTipoMejora(long id) {

		return this.ucFindTipoMejora.findTipoMejora(id);
	}

	@Override
	public Page<TipoMejoraEto> findTipoMejoras(TipoMejoraSearchCriteriaTo criteria) {
		return this.ucFindTipoMejora.findTipoMejoras(criteria);
	}

	@Override
	public TipoMejoraEto saveTipoMejora(TipoMejoraEto tipomejora) {

		return this.ucManageTipoMejora.saveTipoMejora(tipomejora);
	}

	@Override
	public boolean deleteTipoMejora(long id) {

		return this.ucManageTipoMejora.deleteTipoMejora(id);
	}
}
