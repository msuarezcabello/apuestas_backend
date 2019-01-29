package com.devonfw.application.apuestas_backend.tipomejoramanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.Tipomejoramanagement;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.service.api.rest.TipomejoramanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Tipomejoramanagement}.
 */
@Named("TipomejoramanagementRestService")
public class TipomejoramanagementRestServiceImpl implements TipomejoramanagementRestService {

	@Inject
	private Tipomejoramanagement tipomejoramanagement;

	@Override
	public TipoMejoraEto getTipoMejora(long id) {
		return this.tipomejoramanagement.findTipoMejora(id);
	}

	@Override
	public TipoMejoraEto saveTipoMejora(TipoMejoraEto tipomejora) {
		return this.tipomejoramanagement.saveTipoMejora(tipomejora);
	}

	@Override
	public void deleteTipoMejora(long id) {
		this.tipomejoramanagement.deleteTipoMejora(id);
	}

	@Override
	public Page<TipoMejoraEto> findTipoMejoras(TipoMejoraSearchCriteriaTo searchCriteriaTo) {
		return this.tipomejoramanagement.findTipoMejoras(searchCriteriaTo);
	}
}