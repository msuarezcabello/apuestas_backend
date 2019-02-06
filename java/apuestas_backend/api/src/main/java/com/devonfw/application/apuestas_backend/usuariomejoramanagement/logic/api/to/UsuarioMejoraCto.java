package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of UsuarioMejora
 */
public class UsuarioMejoraCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private UsuarioMejoraEto usuarioMejora;

	private UsuarioEto usuario;
	private MejoraEto mejora;

	public UsuarioMejoraEto getUsuarioMejora() {
		return usuarioMejora;
	}

	public void setUsuarioMejora(UsuarioMejoraEto usuarioMejora) {
		this.usuarioMejora = usuarioMejora;
	}

	public UsuarioEto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEto usuario) {
		this.usuario = usuario;
	}

	public MejoraEto getMejora() {
		return mejora;
	}

	public void setMejora(MejoraEto mejora) {
		this.mejora = mejora;
	}

}
