package com.devonfw.application.apuestas_backend.personamanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.Personamanagement;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Personamanagement}.
 */
@Path("/personamanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PersonamanagementRestService {

	/**
	 * Delegates to {@link Personamanagement#findPersona}.
	 *
	 * @param id the ID of the {@link PersonaEto}
	 * @return the {@link PersonaEto}
	 */
	@GET
	@Path("/persona/{id}/")
	public PersonaEto getPersona(@PathParam("id") long id);

	/**
	 * Delegates to {@link Personamanagement#savePersona}.
	 *
	 * @param persona the {@link PersonaEto} to be saved
	 * @return the recently created {@link PersonaEto}
	 */
	@POST
	@Path("/persona/")
	public PersonaEto savePersona(PersonaEto persona);

	/**
	 * Delegates to {@link Personamanagement#deletePersona}.
	 *
	 * @param id ID of the {@link PersonaEto} to be deleted
	 */
	@DELETE
	@Path("/persona/{id}/")
	public void deletePersona(@PathParam("id") long id);

	/**
	 * Delegates to {@link Personamanagement#findPersonaEtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding personas.
	 * @return the {@link Page list} of matching {@link PersonaEto}s.
	 */
	@Path("/persona/search")
	@POST
	public Page<PersonaEto> findPersonas(PersonaSearchCriteriaTo searchCriteriaTo);

}