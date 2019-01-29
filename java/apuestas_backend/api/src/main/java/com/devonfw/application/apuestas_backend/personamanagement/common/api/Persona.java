package com.devonfw.application.apuestas_backend.personamanagement.common.api;

import com.devonfw.application.apuestas_backend.general.common.api.ApplicationEntity;
import java.sql.Timestamp;
public interface Persona extends ApplicationEntity {

	/**
	 * @return nombreId
	 */

	public String getNombre();

	/**
	 * @param nombre setter for nombre attribute
	 */

	public void setNombre(String nombre);

	/**
	 * @return fechaNacimientoId
	 */

	public Timestamp getFechaNacimiento();

	/**
	 * @param fechaNacimiento setter for fechaNacimiento attribute
	 */

	public void setFechaNacimiento(Timestamp fechaNacimiento);

	/**
	 * @return emailId
	 */

	public String getEmail();

	/**
	 * @param email setter for email attribute
	 */

	public void setEmail(String email);

}
