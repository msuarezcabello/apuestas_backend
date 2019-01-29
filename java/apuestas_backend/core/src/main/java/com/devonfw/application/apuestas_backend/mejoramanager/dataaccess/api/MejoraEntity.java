package com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api;

import javax.persistence.*;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.TipoMejoraEntity;

@Entity
@Table(name = "CreateMejora")
public class MejoraEntity {
	private String descripcion;

	private TipoMejoraEntity tipoMejora;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoMejoraEntity getTipoMejora() {
		return tipoMejora;
	}

	public void setTipoMejora(TipoMejoraEntity tipoMejora) {
		this.tipoMejora = tipoMejora;
	}
}
