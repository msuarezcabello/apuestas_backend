package com.devonfw.application.apuestas_backend.tipomejoramanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.Tipomejoramanagement;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Tipomejoramanagement}.
 */
@Path("/tipomejoramanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TipomejoramanagementRestService {

	/**
	 * Delegates to {@link Tipomejoramanagement#findTipoMejora}.
	 *
	 * @param id the ID of the {@link TipoMejoraEto}
	 * @return the {@link TipoMejoraEto}
	 */
	@GET
	@Path("/tipomejora/{id}/")
	public TipoMejoraEto getTipoMejora(@PathParam("id") long id);

	/**
	 * Delegates to {@link Tipomejoramanagement#saveTipoMejora}.
	 *
	 * @param tipomejora the {@link TipoMejoraEto} to be saved
	 * @return the recently created {@link TipoMejoraEto}
	 */
	@POST
	@Path("/tipomejora/")
	public TipoMejoraEto saveTipoMejora(TipoMejoraEto tipomejora);

	/**
	 * Delegates to {@link Tipomejoramanagement#deleteTipoMejora}.
	 *
	 * @param id ID of the {@link TipoMejoraEto} to be deleted
	 */
	@DELETE
	@Path("/tipomejora/{id}/")
	public void deleteTipoMejora(@PathParam("id") long id);

	/**
	 * Delegates to {@link Tipomejoramanagement#findTipoMejoraEtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding tipomejoras.
	 * @return the {@link Page list} of matching {@link TipoMejoraEto}s.
	 */
	@Path("/tipomejora/search")
	@POST
	public Page<TipoMejoraEto> findTipoMejoras(TipoMejoraSearchCriteriaTo searchCriteriaTo);

}