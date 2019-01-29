package com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;

public interface UcFindApuesta {

	/**
	 * Returns a composite Apuesta by its id 'id'.
	 *
	 * @param id The id 'id' of the Apuesta.
	 * @return The {@link ApuestaCto} with id 'id'
	 */
	ApuestaCto findApuestaCto(long id);

	/**
	 * Returns a paginated list of composite Apuestas matching the search criteria.
	 *
	 * @param criteria the {@link ApuestaSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link ApuestaCto}s.
	 */
	Page<ApuestaCto> findApuestaCtos(ApuestaSearchCriteriaTo criteria);

}
