/**
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
import javax.persistence.Transient;

import com.devonfw.application.apuestas_backend.apuestamanagement.common.api.Apuesta;
import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;

/**
 * @author msuarezc
 */
@Entity
@Table(name = "Apuesta")
public class ApuestaEntity extends ApplicationPersistenceEntity implements Apuesta {

	private Boolean ladoApostado;

	private Boolean resultado;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fecha;

	private double valorApostado;

	private double valorGanado;

	private UsuarioEntity usuario;

	private static final long serialVersionUID = 1L;

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
	public double getValorApostado() {
		return valorApostado;
	}

	/**
	 * @param valorApostado the valorApostado to set
	 */
	public void setValorApostado(double valorApostado) {
		this.valorApostado = valorApostado;
	}

	/**
	 * @return the valorGanado
	 */
	public double getValorGanado() {
		return valorGanado;
	}

	/**
	 * @param valorGanado the valorGanado to set
	 */
	public void setValorGanado(double valorGanado) {
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

	@Override
	@Transient
	public Long getUsuarioId() {

		if (this.usuario == null) {
			return null;
		}
		return this.usuario.getId();
	}

	@Override
	public void setUsuarioId(Long usuarioId) {

		if (usuarioId == null) {
			this.usuario = null;
		} else {
			UsuarioEntity usuarioEntity = new UsuarioEntity();
			usuarioEntity.setId(usuarioId);
			this.usuario = usuarioEntity;
		}
	}

}
