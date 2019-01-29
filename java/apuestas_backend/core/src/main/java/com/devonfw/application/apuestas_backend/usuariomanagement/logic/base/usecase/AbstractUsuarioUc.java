package com.devonfw.application.apuestas_backend.usuariomanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.repo.UsuarioRepository;

/**
 * Abstract use case for Usuarios, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractUsuarioUc extends AbstractUc {

	/** @see #getUsuarioRepository() */
	@Inject
	private UsuarioRepository usuarioRepository;

	/**
	 * Returns the field 'usuarioRepository'.
	 * 
	 * @return the {@link UsuarioRepository} instance.
	 */
	public UsuarioRepository getUsuarioRepository() {

		return this.usuarioRepository;
	}

}
