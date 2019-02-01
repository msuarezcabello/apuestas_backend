/**
 *
 */
package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;

/**
* @author msuarezc
*
*/
public interface UcManageUsuario {

	
	Boolean deleteUsuario(long usuarioId);


	UsuarioEto saveUsuario(UsuarioEto usuarioEto);
}
