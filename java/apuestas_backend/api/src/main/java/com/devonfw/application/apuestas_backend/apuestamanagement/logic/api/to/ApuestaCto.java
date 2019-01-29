package com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Apuesta
 */
public class ApuestaCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private ApuestaEto apuesta;

	private UsuarioEto usuario;

	public ApuestaEto getApuesta() {
		return apuesta;
	}

	public void setApuesta(ApuestaEto apuesta) {
		this.apuesta = apuesta;
	}

	public UsuarioEto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEto usuario) {
		this.usuario = usuario;
	}

}
