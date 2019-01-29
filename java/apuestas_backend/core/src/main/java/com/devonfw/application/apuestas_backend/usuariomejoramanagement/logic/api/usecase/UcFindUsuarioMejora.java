package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraCto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;

public interface UcFindUsuarioMejora {

	/**
	 * Returns a composite UsuarioMejora by its id 'id'.
	 *
	 * @param id The id 'id' of the UsuarioMejora.
	 * @return The {@link UsuarioMejoraCto} with id 'id'
	 */
	UsuarioMejoraCto findUsuarioMejoraCto(long id);

	/**
	 * Returns a paginated list of composite UsuarioMejoras matching the search
	 * criteria.
	 *
	 * @param criteria the {@link UsuarioMejoraSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link UsuarioMejoraCto}s.
	 */
	Page<UsuarioMejoraCto> findUsuarioMejoraCtos(UsuarioMejoraSearchCriteriaTo criteria);

}
