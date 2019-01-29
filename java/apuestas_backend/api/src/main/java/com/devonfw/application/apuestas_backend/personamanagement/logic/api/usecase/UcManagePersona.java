package com.devonfw.application.apuestas_backend.personamanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;

/**
 * Interface of UcManagePersona to centralize documentation and signatures of
 * methods.
 */
public interface UcManagePersona {

	/**
	 * Deletes a persona from the database by its id 'personaId'.
	 *
	 * @param personaId Id of the persona to delete
	 * @return boolean <code>true</code> if the persona can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deletePersona(long personaId);

	/**
	 * Saves a persona and store it in the database.
	 *
	 * @param persona the {@link PersonaEto} to create.
	 * @return the new {@link PersonaEto} that has been saved with ID and version.
	 */
	PersonaEto savePersona(PersonaEto persona);

}
