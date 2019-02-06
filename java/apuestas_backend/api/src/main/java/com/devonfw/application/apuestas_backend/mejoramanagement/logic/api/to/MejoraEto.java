package com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.mejoramanagement.common.api.Mejora;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Mejora
 */
public class MejoraEto extends AbstractEto implements Mejora {

	private static final long serialVersionUID = 1L;

	private String descripcion;

	private Long tipoMejoraId;

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public Long getTipoMejoraId() {
		return tipoMejoraId;
	}

	@Override
	public void setTipoMejoraId(Long tipoMejoraId) {
		this.tipoMejoraId = tipoMejoraId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.descripcion == null) ? 0 : this.descripcion.hashCode());

		result = prime * result + ((this.tipoMejoraId == null) ? 0 : this.tipoMejoraId.hashCode());
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
		MejoraEto other = (MejoraEto) obj;
		if (this.descripcion == null) {
			if (other.descripcion != null) {
				return false;
			}
		} else if (!this.descripcion.equals(other.descripcion)) {
			return false;
		}

		if (this.tipoMejoraId == null) {
			if (other.tipoMejoraId != null) {
				return false;
			}
		} else if (!this.tipoMejoraId.equals(other.tipoMejoraId)) {
			return false;
		}
		return true;
	}
}
