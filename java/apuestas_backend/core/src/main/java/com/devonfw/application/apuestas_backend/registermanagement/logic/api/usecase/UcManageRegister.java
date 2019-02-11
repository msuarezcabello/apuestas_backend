package com.devonfw.application.apuestas_backend.registermanagement.logic.api.usecase;

import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterCto;

public interface UcManageRegister {
	public RegisterCto saveRegisterCto(RegisterCto registerCto);
}
