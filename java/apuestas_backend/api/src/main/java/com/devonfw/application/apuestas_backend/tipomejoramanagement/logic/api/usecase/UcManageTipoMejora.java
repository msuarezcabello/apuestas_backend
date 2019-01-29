package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;

/**
 * Interface of UcManageTipoMejora to centralize documentation and signatures of
 * methods.
 */
public interface UcManageTipoMejora {

	/**
	 * Deletes a tipoMejora from the database by its id 'tipoMejoraId'.
	 *
	 * @param tipoMejoraId Id of the tipoMejora to delete
	 * @return boolean <code>true</code> if the tipoMejora can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteTipoMejora(long tipoMejoraId);

	/**
	 * Saves a tipoMejora and store it in the database.
	 *
	 * @param tipoMejora the {@link TipoMejoraEto} to create.
	 * @return the new {@link TipoMejoraEto} that has been saved with ID and
	 *         version.
	 */
	TipoMejoraEto saveTipoMejora(TipoMejoraEto tipoMejora);

}
