package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api.repo.UsuarioMejoraRepository;

/**
 * Abstract use case for UsuarioMejoras, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractUsuarioMejoraUc extends AbstractUc {

	/** @see #getUsuarioMejoraRepository() */
	@Inject
	private UsuarioMejoraRepository usuarioMejoraRepository;

	/**
	 * Returns the field 'usuarioMejoraRepository'.
	 * 
	 * @return the {@link UsuarioMejoraRepository} instance.
	 */
	public UsuarioMejoraRepository getUsuarioMejoraRepository() {

		return this.usuarioMejoraRepository;
	}

}
