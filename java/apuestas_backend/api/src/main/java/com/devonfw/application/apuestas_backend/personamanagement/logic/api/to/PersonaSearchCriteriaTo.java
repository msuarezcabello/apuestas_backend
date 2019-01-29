package com.devonfw.application.apuestas_backend.personamanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import java.sql.Timestamp;
/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.personamanagement.common.api.Persona}s.
 */
public class PersonaSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private Timestamp fechaNacimiento;
	private String email;
	private StringSearchConfigTo nombreOption;
	private StringSearchConfigTo emailOption;

	/**
	 * @return nombreId
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre setter for nombre attribute
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return fechaNacimientoId
	 */

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento setter for fechaNacimiento attribute
	 */

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return emailId
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email setter for email attribute
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getNombre() nombre}.
	 */
	public StringSearchConfigTo getNombreOption() {

		return this.nombreOption;
	}

	/**
	 * @param nombreOption new value of {@link #getNombreOption()}.
	 */
	public void setNombreOption(StringSearchConfigTo nombreOption) {

		this.nombreOption = nombreOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getEmail() email}.
	 */
	public StringSearchConfigTo getEmailOption() {

		return this.emailOption;
	}

	/**
	 * @param emailOption new value of {@link #getEmailOption()}.
	 */
	public void setEmailOption(StringSearchConfigTo emailOption) {

		this.emailOption = emailOption;
	}

}
