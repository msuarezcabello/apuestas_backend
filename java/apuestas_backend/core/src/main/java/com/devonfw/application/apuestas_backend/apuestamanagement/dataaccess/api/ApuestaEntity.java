/**
 *
 */
package com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;
/**
 * @author msuarezc
 *
 */
@Entity
@Table(name = "Persona")
public class ApuestaEntity {

	private Boolean ladoApostado;

	private Boolean resultado;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fecha;

	private float valorApostado;

	private float valorGanado;

	private UsuarioEntity usuario;

	/**
	 * @return the ladoApostado
	 */
	public Boolean getLadoApostado() {
		return ladoApostado;
	}

	/**
	 * @param ladoApostado the ladoApostado to set
	 */
	public void setLadoApostado(Boolean ladoApostado) {
		this.ladoApostado = ladoApostado;
	}

	/**
	 * @return the resultado
	 */
	public Boolean getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the valorApostado
	 */
	public float getValorApostado() {
		return valorApostado;
	}

	/**
	 * @param valorApostado the valorApostado to set
	 */
	public void setValorApostado(float valorApostado) {
		this.valorApostado = valorApostado;
	}

	/**
	 * @return the valorGanado
	 */
	public float getValorGanado() {
		return valorGanado;
	}

	/**
	 * @param valorGanado the valorGanado to set
	 */
	public void setValorGanado(float valorGanado) {
		this.valorGanado = valorGanado;
	}

	/**
	 * @return the usuario
	 */
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}
