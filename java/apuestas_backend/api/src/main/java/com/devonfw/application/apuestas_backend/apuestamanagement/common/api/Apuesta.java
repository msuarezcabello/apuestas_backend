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

	public double getValorApostado();

	/**
	 * @param valorApostado setter for valorApostado attribute
	 */

	public void setValorApostado(double valorApostado);

	/**
	 * @return valorGanadoId
	 */

	public double getValorGanado();

	/**
	 * @param valorGanado setter for valorGanado attribute
	 */

	public void setValorGanado(double valorGanado);

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
