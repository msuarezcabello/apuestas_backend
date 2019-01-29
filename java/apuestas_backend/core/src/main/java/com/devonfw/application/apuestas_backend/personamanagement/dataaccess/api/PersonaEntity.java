/**
 */
package com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api;



import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.devonfw.application.apuestas_backend.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.apuestas_backend.personamanagement.common.api.Persona;
import java.sql.Timestamp;
/**
 * @author msuarezc
 */
@Entity
@Table(name = "Persona")
public class PersonaEntity extends ApplicationPersistenceEntity implements Persona {

	private String nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fechaNacimiento;

	private String email;

	private static final long serialVersionUID = 1L;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
