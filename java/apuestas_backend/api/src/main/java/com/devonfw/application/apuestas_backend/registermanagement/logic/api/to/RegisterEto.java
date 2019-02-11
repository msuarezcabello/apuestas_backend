package com.devonfw.application.apuestas_backend.registermanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.registermanagement.common.api.Register;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Register
 */
public class RegisterEto extends AbstractEto implements Register {

	private static final long serialVersionUID = 1L;

	private Long personaId;

	private Long usuarioId;

	@Override
	public Long getPersonaId() {
		return personaId;
	}

	@Override
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	@Override
	public Long getUsuarioId() {
		return usuarioId;
	}

	@Override
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result + ((this.personaId == null) ? 0 : this.personaId.hashCode());

		result = prime * result + ((this.usuarioId == null) ? 0 : this.usuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		RegisterEto other = (RegisterEto) obj;

		if (this.personaId == null) {
			if (other.personaId != null) {
				return false;
			}
		} else if (!this.personaId.equals(other.personaId)) {
			return false;
		}

		if (this.usuarioId == null) {
			if (other.usuarioId != null) {
				return false;
			}
		} else if (!this.usuarioId.equals(other.usuarioId)) {
			return false;
		}
		return true;
	}

}
