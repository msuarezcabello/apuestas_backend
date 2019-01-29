package com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Mejora
 */
public class MejoraCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private MejoraEto mejora;

	private TipoMejoraEto tipoMejora;

	public MejoraEto getMejora() {
		return mejora;
	}

	public void setMejora(MejoraEto mejora) {
		this.mejora = mejora;
	}

	public TipoMejoraEto getTipoMejora() {
		return tipoMejora;
	}

	public void setTipoMejora(TipoMejoraEto tipoMejora) {
		this.tipoMejora = tipoMejora;
	}

}
