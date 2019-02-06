/**
 *
 */
package com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraEto;

/**
 * @author msuarezc
 *
 */
public interface UcManageMejora {

	Boolean deleteMejora(long idMejora);

	MejoraEto saveMejora(MejoraEto mejoraEto);
}
