package com.devonfw.application.apuestas_backend.registermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.devonfw.application.apuestas_backend.registermanagement.logic.api.Registermanagement;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterCto;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Registermanagement}.
 */
@Path("/registermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RegistermanagementRestService {
	/*
	@GET
	@Path("/register/cto/{id}/")
	public RegisterCto getRegisterCto(@PathParam("id") long id);

	@Path("/register/cto/search")
	@POST
	public Page<RegisterCto> findRegisterCtos(RegisterSearchCriteriaTo searchCriteriaTo);
	*/

	@Path("/register/cto")
	@POST
	public RegisterCto saveRegisterCto(RegisterCto registerCto);
}
