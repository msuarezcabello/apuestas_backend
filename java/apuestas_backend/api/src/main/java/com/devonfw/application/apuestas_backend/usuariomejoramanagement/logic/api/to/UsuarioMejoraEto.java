package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.common.api.UsuarioMejora;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of UsuarioMejora
 */
public class UsuarioMejoraEto extends AbstractEto implements UsuarioMejora {

	private static final long serialVersionUID = 1L;

	private Long usuarioId;

	private Long mejoraId;

	@Override
	public Long getUsuarioId() {
		return usuarioId;
	}

	@Override
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public Long getMejoraId() {
		return mejoraId;
	}

	@Override
	public void setMejoraId(Long mejoraId) {
		this.mejoraId = mejoraId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result + ((this.usuarioId == null) ? 0 : this.usuarioId.hashCode());

		result = prime * result + ((this.mejoraId == null) ? 0 : this.mejoraId.hashCode());
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
		UsuarioMejoraEto other = (UsuarioMejoraEto) obj;

		if (this.usuarioId == null) {
			if (other.usuarioId != null) {
				return false;
			}
		} else if (!this.usuarioId.equals(other.usuarioId)) {
			return false;
		}

		if (this.mejoraId == null) {
			if (other.mejoraId != null) {
				return false;
			}
		} else if (!this.mejoraId.equals(other.mejoraId)) {
			return false;
		}
		return true;
	}
}
