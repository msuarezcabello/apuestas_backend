package com.devonfw.application.apuestas_backend.apuestamanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.Apuestamanagement;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaEto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Apuestamanagement}.
 */
@Path("/apuestamanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ApuestamanagementRestService {

	/**
	 * Delegates to {@link Apuestamanagement#findApuestaCto}.
	 *
	 * @param id the ID of the {@link ApuestaCto}
	 * @return the {@link ApuestaCto}
	 */
	@GET
	@Path("/apuesta/cto/{id}/")
	public ApuestaCto getApuestaCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Apuestamanagement#findApuestaCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding apuestas.
	 * @return the {@link Page list} of matching {@link ApuestaCto}s.
	 */
	@Path("/apuesta/cto/search")
	@POST
	public Page<ApuestaCto> findApuestaCtos(ApuestaSearchCriteriaTo searchCriteriaTo);

	/**
	 * Delegates to {@link Apuestamanagement#saveApuesta}.
	 *
	 * @param queue the {@link ApuestaEto} to be saved
	 * @return the recently created {@link ApuestaEto}
	 */
	@POST
	@Path("/apuesta/")
	public ApuestaEto saveApuesta(ApuestaEto apuestaEto);

	/**
	 * Delegates to {@link Apuestamanagement#deleteApuesta}.
	 *
	 * @param id ID of the {@link ApuestaEto} to be deleted
	 */
	@DELETE
	@Path("/apuesta/{id}/")
	public void deleteApuesta(@PathParam("id") long id);
}