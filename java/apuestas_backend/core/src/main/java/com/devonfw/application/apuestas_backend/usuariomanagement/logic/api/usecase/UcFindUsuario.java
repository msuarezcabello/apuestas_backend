package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;

public interface UcFindUsuario {

	/**
	 * Returns a composite Usuario by its id 'id'.
	 *
	 * @param id The id 'id' of the Usuario.
	 * @return The {@link UsuarioCto} with id 'id'
	 */
	UsuarioCto findUsuarioCto(long id);

	/**
	 * Returns a paginated list of composite Usuarios matching the search criteria.
	 *
	 * @param criteria the {@link UsuarioSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link UsuarioCto}s.
	 */
	Page<UsuarioCto> findUsuarioCtos(UsuarioSearchCriteriaTo criteria);

	/**
	 * Returns a composite Usuario by its id 'id'.
	 *
	 * @param the Usuario to be logged in
	 * @return If the loggin was successful
	 */
	Boolean loginUsuario(UsuarioEto usuarioEto);
}
