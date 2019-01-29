package com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;
import java.sql.Timestamp;
/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.apuestamanagement.common.api.Apuesta}s.
 */
public class ApuestaSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Boolean ladoApostado;
	private Boolean resultado;
	private Timestamp fecha;
	private Float valorApostado;
	private Float valorGanado;

	private Long usuarioId;

	/**
	 * @return ladoApostadoId
	 */

	public Boolean getLadoApostado() {
		return ladoApostado;
	}

	/**
	 * @param ladoApostado setter for ladoApostado attribute
	 */

	public void setLadoApostado(Boolean ladoApostado) {
		this.ladoApostado = ladoApostado;
	}

	/**
	 * @return resultadoId
	 */

	public Boolean getResultado() {
		return resultado;
	}

	/**
	 * @param resultado setter for resultado attribute
	 */

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return fechaId
	 */

	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha setter for fecha attribute
	 */

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return valorApostadoId
	 */

	public Float getValorApostado() {
		return valorApostado;
	}

	/**
	 * @param valorApostado setter for valorApostado attribute
	 */

	public void setValorApostado(Float valorApostado) {
		this.valorApostado = valorApostado;
	}

	/**
	 * @return valorGanadoId
	 */

	public Float getValorGanado() {
		return valorGanado;
	}

	/**
	 * @param valorGanado setter for valorGanado attribute
	 */

	public void setValorGanado(Float valorGanado) {
		this.valorGanado = valorGanado;
	}

	/**
	 * getter for usuarioId attribute
	 *
	 * @return usuarioId
	 */

	public Long getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuario setter for usuario attribute
	 */

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
