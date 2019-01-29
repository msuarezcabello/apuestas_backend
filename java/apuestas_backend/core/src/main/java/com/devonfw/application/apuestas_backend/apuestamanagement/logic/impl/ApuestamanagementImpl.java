package com.devonfw.application.apuestas_backend.apuestamanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.Apuestamanagement;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaCto;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.usecase.UcFindApuesta;
import com.devonfw.application.apuestas_backend.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of apuestamanagement
 */
@Named
public class ApuestamanagementImpl extends AbstractComponentFacade implements Apuestamanagement {

	@Inject
	private UcFindApuesta ucFindApuesta;

	@Override
	public ApuestaCto findApuestaCto(long id) {

		return ucFindApuesta.findApuestaCto(id);
	}

	@Override
	public Page<ApuestaCto> findApuestaCtos(ApuestaSearchCriteriaTo criteria) {

		return ucFindApuesta.findApuestaCtos(criteria);
	}
}
