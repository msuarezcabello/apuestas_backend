package com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.common.api.TipoMejora;

@Entity
@Table(name = "TipoMejora")
public class TipoMejoraEntity extends ApplicationPersistenceEntity implements TipoMejora {

	private String descripcion;

	private static final long serialVersionUID = 1L;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
