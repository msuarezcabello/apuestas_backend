/**
 *
 */
package com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcFindMejora;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.impl.usecase.UcManageUsuarioImpl;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api.UsuarioMejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraEto;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.usecase.UcManageUsuarioMejora;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.base.usecase.AbstractUsuarioMejoraUc;

/**
 * @author msuarezc
 *
 */
@Named
@Validated
@Transactional
public class UcManageUsuarioMejoraImpl extends AbstractUsuarioMejoraUc implements UcManageUsuarioMejora{

	@Inject
	private UcFindUsuario ucFindUsuario;

	@Inject
	private UcFindMejora ucFindMejora;

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageUsuarioImpl.class);

	@Override
	public Boolean deleteUsuarioMejora(long idUsuarioMejora) {
		try {
			getUsuarioMejoraRepository().deleteById(idUsuarioMejora);
			LOG.debug("The usuarioMejora with id '{}' has been deleted.",idUsuarioMejora);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public UsuarioMejoraEto saveUsuarioMejora(UsuarioMejoraEto usuarioMejoraEto) {
		Objects.requireNonNull(usuarioMejoraEto, "UsuarioMejoraEto usuarioMejoraEto null");

		UsuarioMejoraEntity usuarioMejoraEntity = getBeanMapper().map(usuarioMejoraEto, UsuarioMejoraEntity.class);

		try {
			if(validParameters(usuarioMejoraEto)) {
				UsuarioMejoraEntity usuarioMejoraSaved = getUsuarioMejoraRepository().save(usuarioMejoraEntity);
				return getBeanMapper().map(usuarioMejoraSaved, UsuarioMejoraEto.class);
			}
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public Boolean validParameters(UsuarioMejoraEto usuarioMejoraEto) {
		return (getUcFindUsuario().findUsuarioCto(usuarioMejoraEto.getUsuarioId())!=null &&
		getUcFindMejora().findMejoraCto(usuarioMejoraEto.getMejoraId())!=null)?true:false;
	}

	public UcFindUsuario getUcFindUsuario() {
		return ucFindUsuario;
	}

	public UcFindMejora getUcFindMejora() {
		return ucFindMejora;
	}

}
