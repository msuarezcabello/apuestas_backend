package com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.common.api.TipoMejora;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of TipoMejora
 */
public class TipoMejoraEto extends AbstractEto implements TipoMejora {

	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.descripcion == null) ? 0 : this.descripcion.hashCode());
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
		TipoMejoraEto other = (TipoMejoraEto) obj;
		if (this.descripcion == null) {
			if (other.descripcion != null) {
				return false;
			}
		} else if (!this.descripcion.equals(other.descripcion)) {
			return false;
		}
		return true;
	}
}
