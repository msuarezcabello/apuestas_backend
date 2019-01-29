package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.Usuariomejoramanagement;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraCto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.usecase.UcFindUsuarioMejora;

/**
 * Implementation of component interface of usuariomejoramanagement
 */
@Named
public class UsuariomejoramanagementImpl extends AbstractComponentFacade implements Usuariomejoramanagement {

	@Inject
	private UcFindUsuarioMejora ucFindUsuarioMejora;

	@Override
	public UsuarioMejoraCto findUsuarioMejoraCto(long id) {

		return ucFindUsuarioMejora.findUsuarioMejoraCto(id);
	}

	@Override
	public Page<UsuarioMejoraCto> findUsuarioMejoraCtos(UsuarioMejoraSearchCriteriaTo criteria) {

		return ucFindUsuarioMejora.findUsuarioMejoraCtos(criteria);
	}
}
