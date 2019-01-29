package com.devonfw.application.apuestas_backend.mejoramanager.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.Mejoramanager;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraCto;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.usecase.UcFindMejora;

/**
 * Implementation of component interface of mejoramanager
 */
@Named
public class MejoramanagerImpl extends AbstractComponentFacade implements Mejoramanager {

	@Inject
	private UcFindMejora ucFindMejora;

	@Override
	public MejoraCto findMejoraCto(long id) {

		return ucFindMejora.findMejoraCto(id);
	}

	@Override
	public Page<MejoraCto> findMejoraCtos(MejoraSearchCriteriaTo criteria) {

		return ucFindMejora.findMejoraCtos(criteria);
	}
}
