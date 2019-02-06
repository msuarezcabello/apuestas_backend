/**
 *
 */
package com.devonfw.application.apuestas_backend.mejoramanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.apuestas_backend.mejoramanagement.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.Mejoramanagement;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcFindMejora;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcManageMejora;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.base.usecase.AbstractMejoraUc;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.Tipomejoramanagement;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.usecase.UcFindTipoMejora;

/**
 * @author msuarezc
 *
 */
@Named
@Validated
@Transactional
public class UcManageMejoraImpl extends AbstractMejoraUc implements UcManageMejora {

	@Inject
	private UcFindMejora ucFindMejora;

	@Inject
	private UcFindTipoMejora ucFindTipoMejora;

	@Inject
	private Mejoramanagement mejoramanagement;


	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageMejoraImpl.class);

	public UcFindMejora getUcFindMejora() {
		return ucFindMejora;
	}

	public UcFindTipoMejora getUcFindTipoMejora() {
		return ucFindTipoMejora;
	}


	public Mejoramanagement getMejoramanagement() {
		return mejoramanagement;
	}

	@Override
	public Boolean deleteMejora(long idMejora) {
		try {
			getMejoraRepository().deleteById(idMejora);
			LOG.debug("The mejora with id '{}' has been deleted.",idMejora);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public MejoraEto saveMejora(MejoraEto mejoraEto) {
		Objects.requireNonNull(mejoraEto,"MejoraEto mejoraEto null");

		MejoraEntity mejoraEntity = getBeanMapper().map(mejoraEto, MejoraEntity.class);
		try {
			validateTipoMejoraExist(mejoraEntity.getTipoMejoraId());
		} catch (IllegalArgumentException e) {
			return null;
		}

		MejoraEntity mejoraSaved = getMejoraRepository().save(mejoraEntity);

		return getBeanMapper().map(mejoraSaved, MejoraEto.class);
	}

	public Boolean validateTipoMejoraExist(long idTipoMejora) throws IllegalArgumentException {
		return (null==getUcFindTipoMejora().findTipoMejora(idTipoMejora))?true:false;
	}

}
