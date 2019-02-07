/**
 *
 */
package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraEto;

/**
 * @author msuarezc
 *
 */
public interface UcManageUsuarioMejora {
	Boolean deleteUsuarioMejora(long idUsuarioMejora);

	UsuarioMejoraEto saveUsuarioMejora(UsuarioMejoraEto usuarioMejoraEto);
}
