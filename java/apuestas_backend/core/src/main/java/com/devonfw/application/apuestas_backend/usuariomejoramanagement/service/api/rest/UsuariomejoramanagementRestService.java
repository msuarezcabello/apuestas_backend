package com.devonfw.application.apuestas_backend.usuariomejoramanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.Usuariomejoramanagement;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraCto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Usuariomejoramanagement}.
 */
@Path("/usuariomejoramanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsuariomejoramanagementRestService {

	/**
	 * Delegates to {@link Usuariomejoramanagement#findUsuarioMejoraCto}.
	 *
	 * @param id the ID of the {@link UsuarioMejoraCto}
	 * @return the {@link UsuarioMejoraCto}
	 */
	@GET
	@Path("/usuariomejora/cto/{id}/")
	public UsuarioMejoraCto getUsuarioMejoraCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Usuariomejoramanagement#findUsuarioMejoraCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding usuariomejoras.
	 * @return the {@link Page list} of matching {@link UsuarioMejoraCto}s.
	 */
	@Path("/usuariomejora/cto/search")
	@POST
	public Page<UsuarioMejoraCto> findUsuarioMejoraCtos(UsuarioMejoraSearchCriteriaTo searchCriteriaTo);

}