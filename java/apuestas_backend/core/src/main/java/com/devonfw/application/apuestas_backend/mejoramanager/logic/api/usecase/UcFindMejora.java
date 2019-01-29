package com.devonfw.application.apuestas_backend.mejoramanager.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;

public interface UcFindMejora {

	/**
	 * Returns a composite Mejora by its id 'id'.
	 *
	 * @param id The id 'id' of the Mejora.
	 * @return The {@link MejoraCto} with id 'id'
	 */
	MejoraCto findMejoraCto(long id);

	/**
	 * Returns a paginated list of composite Mejoras matching the search criteria.
	 *
	 * @param criteria the {@link MejoraSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link MejoraCto}s.
	 */
	Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo criteria);

}
