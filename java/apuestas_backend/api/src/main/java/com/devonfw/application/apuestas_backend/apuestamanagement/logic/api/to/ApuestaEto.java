package com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.apuestamanagement.common.api.Apuesta;
import com.devonfw.module.basic.common.api.to.AbstractEto;
import java.sql.Timestamp;
/**
 * Entity transport object of Apuesta
 */
public class ApuestaEto extends AbstractEto implements Apuesta {

	private static final long serialVersionUID = 1L;

	private Boolean ladoApostado;
	private Boolean resultado;
	private Timestamp fecha;
	private double valorApostado;
	private double valorGanado;

	private Long usuarioId;

	@Override
	public Boolean getLadoApostado() {
		return ladoApostado;
	}

	@Override
	public void setLadoApostado(Boolean ladoApostado) {
		this.ladoApostado = ladoApostado;
	}

	@Override
	public Boolean getResultado() {
		return resultado;
	}

	@Override
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	@Override
	public Timestamp getFecha() {
		return fecha;
	}

	@Override
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public double getValorApostado() {
		return valorApostado;
	}

	@Override
	public void setValorApostado(double valorApostado) {
		this.valorApostado = valorApostado;
	}

	@Override
	public double getValorGanado() {
		return valorGanado;
	}

	@Override
	public void setValorGanado(double valorGanado) {
		this.valorGanado = valorGanado;
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
		result = prime * result + ((this.ladoApostado == null) ? 0 : this.ladoApostado.hashCode());
		result = prime * result + ((this.resultado == null) ? 0 : this.resultado.hashCode());
		result = prime * result + ((this.fecha == null) ? 0 : this.fecha.hashCode());
		result = prime * result + ((Double) valorApostado).hashCode();
		result = prime * result + ((Double) valorGanado).hashCode();

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
		ApuestaEto other = (ApuestaEto) obj;
		if (this.ladoApostado == null) {
			if (other.ladoApostado != null) {
				return false;
			}
		} else if (!this.ladoApostado.equals(other.ladoApostado)) {
			return false;
		}
		if (this.resultado == null) {
			if (other.resultado != null) {
				return false;
			}
		} else if (!this.resultado.equals(other.resultado)) {
			return false;
		}
		if (this.fecha == null) {
			if (other.fecha != null) {
				return false;
			}
		} else if (!this.fecha.equals(other.fecha)) {
			return false;
		}
		if (this.valorApostado != other.valorApostado) {
			return false;
		}
		if (this.valorGanado != other.valorGanado) {
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
