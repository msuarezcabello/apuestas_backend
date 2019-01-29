package com.devonfw.application.apuestas_backend.personamanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.personamanagement.common.api.Persona;
import com.devonfw.module.basic.common.api.to.AbstractEto;
import java.sql.Timestamp;
/**
 * Entity transport object of Persona
 */
public class PersonaEto extends AbstractEto implements Persona {

	private static final long serialVersionUID = 1L;

	private String nombre;


	private Timestamp fechaNacimiento;

	private String email;

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.nombre == null) ? 0 : this.nombre.hashCode());
		result = prime * result + ((this.fechaNacimiento == null) ? 0 : this.fechaNacimiento.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
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
		PersonaEto other = (PersonaEto) obj;
		if (this.nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!this.nombre.equals(other.nombre)) {
			return false;
		}
		if (this.fechaNacimiento == null) {
			if (other.fechaNacimiento != null) {
				return false;
			}
		} else if (!this.fechaNacimiento.equals(other.fechaNacimiento)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		return true;
	}
}
