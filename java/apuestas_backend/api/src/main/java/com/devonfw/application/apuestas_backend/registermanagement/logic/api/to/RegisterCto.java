package com.devonfw.application.apuestas_backend.registermanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Register
 */
public class RegisterCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private RegisterEto register;

	private PersonaEto persona;

	private UsuarioEto usuario;

	public RegisterEto getRegister() {
		return register;
	}

	public void setRegister(RegisterEto register) {
		this.register = register;
	}

	public PersonaEto getPersona() {
		return persona;
	}

	public void setPersona(PersonaEto persona) {
		this.persona = persona;
	}

	public UsuarioEto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEto usuario) {
		this.usuario = usuario;
	}

}
