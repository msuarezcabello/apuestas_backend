package com.devonfw.application.apuestas_backend.mejoramanager.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.Mejoramanager;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Mejoramanager}.
 */
@Path("/mejoramanager/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MejoramanagerRestService {

	/**
	 * Delegates to {@link Mejoramanager#findMejoraCto}.
	 *
	 * @param id the ID of the {@link MejoraCto}
	 * @return the {@link MejoraCto}
	 */
	@GET
	@Path("/mejora/cto/{id}/")
	public MejoraCto getMejoraCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Mejoramanager#findMejoraCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding mejoras.
	 * @return the {@link Page list} of matching {@link MejoraCto}s.
	 */
	@Path("/mejora/cto/search")
	@POST
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo searchCriteriaTo);

}