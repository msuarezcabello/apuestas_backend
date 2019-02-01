package com.devonfw.application.apuestas_backend.usuariomanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcManageUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.Usuariomanagement;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;

/**
 * Implementation of component interface of usuariomanagement
 */
@Named
public class UsuariomanagementImpl extends AbstractComponentFacade implements Usuariomanagement {

	@Inject
	private UcFindUsuario ucFindUsuario;

	@Inject
	private UcManageUsuario ucManageUsuario;


	@Override
	public UsuarioCto findUsuarioCto(long id) {

		return ucFindUsuario.findUsuarioCto(id);
	}

	@Override
	public Page<UsuarioCto> findUsuarioCtos(UsuarioSearchCriteriaTo criteria) {

		return ucFindUsuario.findUsuarioCtos(criteria);
	}

	@Override
	public UsuarioEto saveUsuario(UsuarioEto usuarioEto) {

		return ucManageUsuario.saveUsuario(usuarioEto);
	}
}
