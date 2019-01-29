package com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api;

import javax.persistence.*;

@Entity
@Table(name = "TipoMejora")
public class TipoMejoraEntity {
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
