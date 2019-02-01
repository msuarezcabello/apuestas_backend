package com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaEto;

public interface UcManageApuesta {
	Boolean deleteApuesta(long apuestaId);

	ApuestaEto saveApuesta(ApuestaEto apuesta);
}
