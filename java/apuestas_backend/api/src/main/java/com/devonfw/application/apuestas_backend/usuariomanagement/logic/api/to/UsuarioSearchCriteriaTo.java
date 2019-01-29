package com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.usuariomanagement.common.api.Usuario}s.
 */
public class UsuarioSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	private Long personaId;
	private StringSearchConfigTo usernameOption;
	private StringSearchConfigTo passwordOption;

	/**
	 * @return usernameId
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * @param username setter for username attribute
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return passwordId
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password setter for password attribute
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter for personaId attribute
	 * 
	 * @return personaId
	 */

	public Long getPersonaId() {
		return personaId;
	}

	/**
	 * @param persona setter for persona attribute
	 */

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getUsername() username}.
	 */
	public StringSearchConfigTo getUsernameOption() {

		return this.usernameOption;
	}

	/**
	 * @param usernameOption new value of {@link #getUsernameOption()}.
	 */
	public void setUsernameOption(StringSearchConfigTo usernameOption) {

		this.usernameOption = usernameOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getPassword() password}.
	 */
	public StringSearchConfigTo getPasswordOption() {

		return this.passwordOption;
	}

	/**
	 * @param passwordOption new value of {@link #getPasswordOption()}.
	 */
	public void setPasswordOption(StringSearchConfigTo passwordOption) {

		this.passwordOption = passwordOption;
	}

}
