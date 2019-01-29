package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractUc;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.repo.TipoMejoraRepository;

/**
 * Abstract use case for TipoMejoras, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractTipoMejoraUc extends AbstractUc {

	/** @see #getTipoMejoraRepository() */
	@Inject
	private TipoMejoraRepository tipoMejoraRepository;

	/**
	 * Returns the field 'tipoMejoraRepository'.
	 * 
	 * @return the {@link TipoMejoraRepository} instance.
	 */
	public TipoMejoraRepository getTipoMejoraRepository() {

		return this.tipoMejoraRepository;
	}

}
