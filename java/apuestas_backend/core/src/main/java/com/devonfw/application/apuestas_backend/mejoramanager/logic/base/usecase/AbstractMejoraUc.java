package com.devonfw.application.apuestas_backend.mejoramanager.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;
import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.repo.MejoraRepository;

/**
 * Abstract use case for Mejoras, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractMejoraUc extends AbstractUc {

	/** @see #getMejoraRepository() */
	@Inject
	private MejoraRepository mejoraRepository;

	/**
	 * Returns the field 'mejoraRepository'.
	 * 
	 * @return the {@link MejoraRepository} instance.
	 */
	public MejoraRepository getMejoraRepository() {

		return this.mejoraRepository;
	}

}
