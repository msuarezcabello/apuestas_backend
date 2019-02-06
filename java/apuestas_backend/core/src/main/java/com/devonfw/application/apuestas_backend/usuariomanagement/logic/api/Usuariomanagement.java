package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcManageUsuario;

/**
 * Interface for Usuariomanagement component.
 */
public interface Usuariomanagement extends UcFindUsuario,UcManageUsuario {

}
