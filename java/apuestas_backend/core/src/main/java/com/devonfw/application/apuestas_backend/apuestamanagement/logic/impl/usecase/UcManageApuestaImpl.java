package com.devonfw.application.apuestas_backend.apuestamanagement.logic.impl.usecase;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api.ApuestaEntity;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.Apuestamanagement;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaEto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase.UcFindApuesta;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase.UcManageApuesta;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.base.usecase.AbstractApuestaUc;
import com.devonfw.application.apuestas_backend.usuariomanagement.dataaccess.api.UsuarioEntity;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.to.UsuarioCto;
import com.devonfw.application.apuestas_backend.usuariomanagement.logic.api.usecase.UcFindUsuario;

@Named
@Validated
@Transactional
@Primary
public class UcManageApuestaImpl extends AbstractApuestaUc implements UcManageApuesta {
	@Inject
	private Apuestamanagement apuestamanagement;

	@Inject
	private UcFindApuesta ucFindApuesta;

	@Inject
	private UcFindUsuario ucFindUsuario;

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageApuestaImpl.class);

	@Override
	public Boolean deleteApuesta(long apuestaId) {
		ApuestaCto apuestaCto = getApuestamanagement().findApuestaCto(apuestaId);

		ApuestaEntity apuestaEntity = getBeanMapper().map(apuestaCto, ApuestaEntity.class);

		getApuestaRepository().delete(apuestaEntity);

		LOG.debug("The apuesta with id '{}' has been deleted.", apuestaCto.getApuesta().getId());

		return true;
	}

	@Override
	public ApuestaEto saveApuesta(ApuestaEto apuestaEto) {

		Objects.requireNonNull(apuestaEto, "UcManageApuestaImpl apuesta null");

		ApuestaEntity apuestaEntity = getBeanMapper().map(apuestaEto, ApuestaEntity.class);
		try {
			valdiateUsuarioIdExist(apuestaEto.getUsuarioId());
		} catch (IllegalArgumentException e) {
			return null;
		}
		apuestaEntity.setFecha(Timestamp.from(Instant.now()));
		// Tengo el id del usuario al que quiero relacionar en el Eto?
		ApuestaEntity apuestaSaved = getApuestaRepository().save(apuestaEntity);




//		LOG.debug("The apuesta with id '{}' has been saved.", apuestaEntity.getId());
		return getBeanMapper().map(apuestaSaved, ApuestaEto.class);

//		UsuarioCto usuarioCto = getUcFindUsuario().findUsuarioCto(apuestaEto.getUsuarioId());
//		UsuarioEntity usuarioEntity = getBeanMapper().map(usuarioCto.getUsuario(), UsuarioEntity.class);
//
//		apuestaEntity.setFecha(Timestamp.from(Instant.now()));
//		apuestaEntity.setUsuario(usuarioEntity);
//
//		ApuestaEntity apuestaSaved = getApuestaRepository().save(apuestaEntity);
//		LOG.debug("The apuesta with id '{}' has been saved.", apuestaSaved.getId());
//
//		return null;
	}

	private void valdiateUsuarioIdExist(long usuarioId) throws IllegalArgumentException {
		UsuarioCto usuarioCto = getUcFindUsuario().findUsuarioCto(usuarioId);
//		(null == usuarioCto) ? throw new IllegalArgumentException() : return;
	}

	public Apuestamanagement getApuestamanagement() {
		return apuestamanagement;
	}

	public UcFindApuesta getUcFindApuesta() {
		return ucFindApuesta;
	}

	public UcFindUsuario getUcFindUsuario() {
		return ucFindUsuario;
	}
}
