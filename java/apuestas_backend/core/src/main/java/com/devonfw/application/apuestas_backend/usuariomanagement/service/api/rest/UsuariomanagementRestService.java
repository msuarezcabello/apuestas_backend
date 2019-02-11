package com.devonfw.application.apuestas_backend.usuariomanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.Usuariomanagement;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Usuariomanagement}.
 */
@Path("/usuariomanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsuariomanagementRestService {

	/**
	 * Delegates to {@link Usuariomanagement#findUsuarioCto}.
	 *
	 * @param id the ID of the {@link UsuarioCto}
	 * @return the {@link UsuarioCto}
	 */
	@GET
	@Path("/usuario/cto/{id}/")
	public UsuarioCto getUsuarioCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Usuariomanagement#findUsuarioCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding usuarios.
	 * @return the {@link Page list} of matching {@link UsuarioCto}s.
	 */
	@Path("/usuario/cto/search")
	@POST
	public Page<UsuarioCto> findUsuarioCtos(UsuarioSearchCriteriaTo searchCriteriaTo);

	/**
	 * Delegates to {@link Usuarioemanagement#saveUsuario}.
	 *
	 * @param queue the {@link UsuarioEto} to be saved
	 * @return the recently created {@link UsuarioEto}
	 */

	@POST
	@Path("/usuario/cto/")
	public UsuarioEto saveUsuario(UsuarioEto usuarioEto);

	/**
	 * @param queue the {@link usuarioId} to be deleted
	 * @return a Boolean
	 */
	@DELETE
	@Path("/usuario/{id}")
	public Boolean deleteUsuario(@PathParam("id") long id);

	/**
	 * @param the {@link usuarioId} to be logged in
	 * @return a Boolean
	 */
	@POST
	@Path("/usuario/login/")
	public Boolean loginUsuario(UsuarioEto usuarioEto);
}