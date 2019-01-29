package com.devonfw.application.apuestas_backend.apuestamanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;
import java.sql.Timestamp;
public interface Apuesta extends ApplicationEntity {

	/**
	 * @return ladoApostadoId
	 */

	public Boolean getLadoApostado();

	/**
	 * @param ladoApostado setter for ladoApostado attribute
	 */

	public void setLadoApostado(Boolean ladoApostado);

	/**
	 * @return resultadoId
	 */

	public Boolean getResultado();

	/**
	 * @param resultado setter for resultado attribute
	 */

	public void setResultado(Boolean resultado);

	/**
	 * @return fechaId
	 */

	public Timestamp getFecha();

	/**
	 * @param fecha setter for fecha attribute
	 */

	public void setFecha(Timestamp fecha);

	/**
	 * @return valorApostadoId
	 */

	public float getValorApostado();

	/**
	 * @param valorApostado setter for valorApostado attribute
	 */

	public void setValorApostado(float valorApostado);

	/**
	 * @return valorGanadoId
	 */

	public float getValorGanado();

	/**
	 * @param valorGanado setter for valorGanado attribute
	 */

	public void setValorGanado(float valorGanado);

	/**
	 * getter for usuarioId attribute
	 *
	 * @return usuarioId
	 */

	public Long getUsuarioId();

	/**
	 * @param usuario setter for usuario attribute
	 */

	public void setUsuarioId(Long usuarioId);

}
