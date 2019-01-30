package com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.mejoramanager.common.api.Mejora;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.TipoMejoraEntity;

@Entity
@Table(name = "Mejora")
public class MejoraEntity extends ApplicationPersistenceEntity implements Mejora {

	private String descripcion;

	private TipoMejoraEntity tipoMejora;

	private static final long serialVersionUID = 1L;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoMejora")
	public TipoMejoraEntity getTipoMejora() {
		return tipoMejora;
	}

	public void setTipoMejora(TipoMejoraEntity tipoMejora) {
		this.tipoMejora = tipoMejora;
	}

	@Override
	@Transient
	public Long getTipoMejoraId() {

		if (this.tipoMejora == null) {
			return null;
		}
		return this.tipoMejora.getId();
	}

	@Override
	public void setTipoMejoraId(Long tipoMejoraId) {

		if (tipoMejoraId == null) {
			this.tipoMejora = null;
		} else {
			TipoMejoraEntity tipoMejoraEntity = new TipoMejoraEntity();
			tipoMejoraEntity.setId(tipoMejoraId);
			this.tipoMejora = tipoMejoraEntity;
		}
	}

}
