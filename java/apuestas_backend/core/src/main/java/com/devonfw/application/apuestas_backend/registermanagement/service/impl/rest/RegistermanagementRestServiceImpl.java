package com.devonfw.application.apuestas_backend.registermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.registermanagement.logic.api.Registermanagement;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterCto;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.registermanagement.service.api.rest.RegistermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Registermanagement}.
 */
@Named("RegistermanagementRestService")
public class RegistermanagementRestServiceImpl implements RegistermanagementRestService {

	@Inject
	private Registermanagement registermanagement;

	@Override
	public RegisterCto saveRegisterCto(RegisterCto registerCto) {
		return registermanagement.saveRegisterCto(registerCto);
	}
	/*

	@Override
	public RegisterCto getRegisterCto(long id) {
		return this.registermanagement.findRegisterCto(id);
	}

	@Override
	public Page<RegisterCto> findRegisterCtos(RegisterSearchCriteriaTo searchCriteriaTo) {
		return this.registermanagement.findRegisterCtos(searchCriteriaTo);
	}
	*/
}
