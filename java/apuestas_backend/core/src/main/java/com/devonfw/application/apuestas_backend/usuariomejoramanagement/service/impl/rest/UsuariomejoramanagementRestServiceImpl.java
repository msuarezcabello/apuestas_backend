package com.devonfw.application.apuestas_backend.usuariomejoramanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.Usuariomejoramanagement;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraCto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraEto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.service.api.rest.UsuariomejoramanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Usuariomejoramanagement}.
 */
@Named("UsuariomejoramanagementRestService")
public class UsuariomejoramanagementRestServiceImpl implements UsuariomejoramanagementRestService {

	@Inject
	private Usuariomejoramanagement usuariomejoramanagement;

	@Override
	public UsuarioMejoraCto getUsuarioMejoraCto(long id) {
		return this.usuariomejoramanagement.findUsuarioMejoraCto(id);
	}

	@Override
	public Page<UsuarioMejoraCto> findUsuarioMejoraCtos(UsuarioMejoraSearchCriteriaTo searchCriteriaTo) {
		return this.usuariomejoramanagement.findUsuarioMejoraCtos(searchCriteriaTo);
	}

	@Override
	public UsuarioMejoraEto saveUsuarioMejora(UsuarioMejoraEto UsuarioMejoraEto) {
		return usuariomejoramanagement.saveUsuarioMejora(UsuarioMejoraEto);
	}

	@Override
	public Boolean deleteUsuarioMejora(long idUsuarioMejora) {
		return usuariomejoramanagement.deleteUsuarioMejora(idUsuarioMejora);
	}
}