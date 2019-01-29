package com.devonfw.application.apuestas_backend.mejoramanager.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.Mejoramanager;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanager.service.api.rest.MejoramanagerRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Mejoramanager}.
 */
@Named("MejoramanagerRestService")
public class MejoramanagerRestServiceImpl implements MejoramanagerRestService {

	@Inject
	private Mejoramanager mejoramanager;

	@Override
	public MejoraCto getMejoraCto(long id) {
		return this.mejoramanager.findMejoraCto(id);
	}

	@Override
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo searchCriteriaTo) {
		return this.mejoramanager.findMejoraCtos(searchCriteriaTo);
	}
}