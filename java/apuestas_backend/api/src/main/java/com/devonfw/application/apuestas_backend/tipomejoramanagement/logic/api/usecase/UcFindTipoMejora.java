package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;

public interface UcFindTipoMejora {

	/**
	 * Returns a TipoMejora by its id 'id'.
	 *
	 * @param id The id 'id' of the TipoMejora.
	 * @return The {@link TipoMejoraEto} with id 'id'
	 */
	TipoMejoraEto findTipoMejora(long id);

	/**
	 * Returns a paginated list of TipoMejoras matching the search criteria.
	 *
	 * @param criteria the {@link TipoMejoraSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link TipoMejoraEto}s.
	 */
	Page<TipoMejoraEto> findTipoMejoras(TipoMejoraSearchCriteriaTo criteria);

}
