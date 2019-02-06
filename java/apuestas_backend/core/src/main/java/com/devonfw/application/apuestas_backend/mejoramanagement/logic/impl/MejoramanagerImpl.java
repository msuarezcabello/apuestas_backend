package com.devonfw.application.apuestas_backend.mejoramanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.Mejoramanagement;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraEto;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcFindMejora;
import com.devonfw.application.apuestas_backend.mejoramanagement.logic.api.usecase.UcManageMejora;

/**
 * Implementation of component interface of mejoramanager
 */
@Named
public class MejoramanagerImpl extends AbstractComponentFacade implements Mejoramanagement {

	@Inject
	private UcFindMejora ucFindMejora;

	@Inject
	private UcManageMejora ucManageMejora;

	@Override
	public MejoraCto findMejoraCto(long id) {

		return ucFindMejora.findMejoraCto(id);
	}

	@Override
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo criteria) {

		return ucFindMejora.findMejoraCtos(criteria);
	}

	@Override
	public Boolean deleteMejora(long idMejora) {
		return ucManageMejora.deleteMejora(idMejora);
	}

	@Override
	public MejoraEto saveMejora(MejoraEto mejoraEto) {
		return ucManageMejora.saveMejora(mejoraEto);
	}
}
