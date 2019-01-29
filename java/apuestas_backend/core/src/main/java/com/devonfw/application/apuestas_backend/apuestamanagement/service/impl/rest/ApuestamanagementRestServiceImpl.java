package com.devonfw.application.apuestas_backend.apuestamanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.Apuestamanagement;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.apuestamanagement.service.api.rest.ApuestamanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Apuestamanagement}.
 */
@Named("ApuestamanagementRestService")
public class ApuestamanagementRestServiceImpl implements ApuestamanagementRestService {

	@Inject
	private Apuestamanagement apuestamanagement;

	@Override
	public ApuestaCto getApuestaCto(long id) {
		return this.apuestamanagement.findApuestaCto(id);
	}

	@Override
	public Page<ApuestaCto> findApuestaCtos(ApuestaSearchCriteriaTo searchCriteriaTo) {
		return this.apuestamanagement.findApuestaCtos(searchCriteriaTo);
	}
}