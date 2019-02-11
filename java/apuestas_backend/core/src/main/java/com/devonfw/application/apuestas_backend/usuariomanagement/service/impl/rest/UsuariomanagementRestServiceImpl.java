package com.devonfw.application.apuestas_backend.usuariomanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.Usuariomanagement;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioEto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomanagement.service.api.rest.UsuariomanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Usuariomanagement}.
 */
@Named("UsuariomanagementRestService")
public class UsuariomanagementRestServiceImpl implements UsuariomanagementRestService {

	@Inject
	private Usuariomanagement usuariomanagement;

	@Override
	public UsuarioCto getUsuarioCto(long id) {
		return this.usuariomanagement.findUsuarioCto(id);
	}

	@Override
	public Page<UsuarioCto> findUsuarioCtos(UsuarioSearchCriteriaTo searchCriteriaTo) {
		return this.usuariomanagement.findUsuarioCtos(searchCriteriaTo);
	}

	@Override
	public UsuarioEto saveUsuario(UsuarioEto usuarioEto) {
		return this.usuariomanagement.saveUsuario(usuarioEto);
	}

	@Override
	public Boolean deleteUsuario(long usuarioId) {
		return this.usuariomanagement.deleteUsuario(usuarioId);
	}

	@Override
	public Boolean loginUsuario(UsuarioEto usuarioEto) {
		return this.usuariomanagement.loginUsuario(usuarioEto);
	}
}