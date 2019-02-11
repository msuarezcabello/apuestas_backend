package com.devonfw.application.apuestas_backend.registermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.Registermanagement;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.to.RegisterCto;
import com.devonfw.application.apuestas_backend.registermanagement.logic.api.usecase.UcManageRegister;

/**
 * Implementation of component interface of registermanagement
 */
@Named
public class RegistermanagementImpl extends AbstractComponentFacade implements Registermanagement {

	@Inject
	private UcManageRegister ucManageRegister;

	@Override
	public RegisterCto saveRegisterCto(RegisterCto registerCto) {
		return this.ucManageRegister.saveRegisterCto(registerCto);
	}

}
