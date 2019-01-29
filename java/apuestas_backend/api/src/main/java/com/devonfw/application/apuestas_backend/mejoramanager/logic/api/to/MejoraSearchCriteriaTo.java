package com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to;

import com.devonfw.application.apuestas_backend.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.apuestas_backend.mejoramanager.common.api.Mejora}s.
 */
public class MejoraSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String descripcion;

	private Long tipoMejoraId;
	private StringSearchConfigTo descripcionOption;

	/**
	 * @return descripcionId
	 */

	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion setter for descripcion attribute
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * getter for tipoMejoraId attribute
	 * 
	 * @return tipoMejoraId
	 */

	public Long getTipoMejoraId() {
		return tipoMejoraId;
	}

	/**
	 * @param tipoMejora setter for tipoMejora attribute
	 */

	public void setTipoMejoraId(Long tipoMejoraId) {
		this.tipoMejoraId = tipoMejoraId;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getDescripcion() descripcion}.
	 */
	public StringSearchConfigTo getDescripcionOption() {

		return this.descripcionOption;
	}

	/**
	 * @param descripcionOption new value of {@link #getDescripcionOption()}.
	 */
	public void setDescripcionOption(StringSearchConfigTo descripcionOption) {

		this.descripcionOption = descripcionOption;
	}

}
