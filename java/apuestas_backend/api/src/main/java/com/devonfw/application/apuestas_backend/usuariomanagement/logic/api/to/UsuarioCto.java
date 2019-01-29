package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Usuario
 */
public class UsuarioCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private UsuarioEto usuario;

	private PersonaEto persona;

	public UsuarioEto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEto usuario) {
		this.usuario = usuario;
	}

	public PersonaEto getPersona() {
		return persona;
	}

	public void setPersona(PersonaEto persona) {
		this.persona = persona;
	}

}
