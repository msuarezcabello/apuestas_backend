package com.devonfw.application.apuestas_backend.mejoramanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.Mejoramanagement;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanagement.service.api.rest.MejoramanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Mejoramanagement}.
 */
@Named("MejoramanagementRestService")
public class MejoramanagementRestServiceImpl implements MejoramanagementRestService {

	@Inject
	private Mejoramanagement mejoramanagement;

	@Override
	public MejoraCto getMejoraCto(long id) {
		return this.mejoramanagement.findMejoraCto(id);
	}

	@Override
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo searchCriteriaTo) {
		return this.mejoramanagement.findMejoraCtos(searchCriteriaTo);
	}

	@Override
	public MejoraEto saveMejora(MejoraEto mejoraEto) {
		return mejoramanagement.saveMejora(mejoraEto);
	}

	@Override
	public Boolean deleteMejora(long idMejora) {
		return mejoramanagement.deleteMejora(idMejora);
	}
}