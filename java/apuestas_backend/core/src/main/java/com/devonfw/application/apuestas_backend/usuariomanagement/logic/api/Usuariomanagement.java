package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;

/**
 * Interface for Usuariomanagement component.
 */
public interface Usuariomanagement extends UcFindUsuario {

	UsuarioEto saveUsuario(UsuarioEto usuarioEto);
}
