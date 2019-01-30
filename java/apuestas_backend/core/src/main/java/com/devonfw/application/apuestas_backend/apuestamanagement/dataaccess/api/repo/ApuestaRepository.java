package com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;
import java.sql.Timestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.apuestas_backend.apuestamanagement.dataaccess.api.ApuestaEntity;
import com.devonfw.application.apuestas_backend.apuestamanagement.logic.api.to.ApuestaSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link ApuestaEntity}
 */
public interface ApuestaRepository extends DefaultRepository<ApuestaEntity> {

	/**
	 * @param criteria    the {@link ApuestaSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link ApuestaEntity} objects that matched
	 *         the search.
	 */
	default Page<ApuestaEntity> findByCriteria(ApuestaSearchCriteriaTo criteria) {

		ApuestaEntity alias = newDslAlias();
		JPAQuery<ApuestaEntity> query = newDslQuery(alias);

		Boolean ladoApostado = criteria.getLadoApostado();
		if (ladoApostado != null) {
			query.where($(alias.getLadoApostado()).eq(ladoApostado));
		}
		Boolean resultado = criteria.getResultado();
		if (resultado != null) {
			query.where($(alias.getResultado()).eq(resultado));
		}
		Timestamp fecha = criteria.getFecha();
		if (fecha != null) {
			query.where($(alias.getFecha()).eq(fecha));
		}
		Double valorApostado = criteria.getValorApostado();
		if (valorApostado != null) {
			query.where($(alias.getValorApostado()).eq(valorApostado));
		}
		Double valorGanado = criteria.getValorGanado();
		if (valorGanado != null) {
			query.where($(alias.getValorGanado()).eq(valorGanado));
		}
		Long usuario = criteria.getUsuarioId();
		if (usuario != null) {
			query.where($(alias.getUsuario().getId()).eq(usuario));
		}
		addOrderBy(query, alias, criteria.getPageable().getSort());

		return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
	}

	/**
	 * Add sorting to the given query on the given alias
	 *
	 * @param query to add sorting to
	 * @param alias to retrieve columns from for sorting
	 * @param sort  specification of sorting
	 */
	public default void addOrderBy(JPAQuery<ApuestaEntity> query, ApuestaEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "ladoApostado":
					if (next.isAscending()) {
						query.orderBy($(alias.getLadoApostado()).asc());
					} else {
						query.orderBy($(alias.getLadoApostado()).desc());
					}
					break;
				case "resultado":
					if (next.isAscending()) {
						query.orderBy($(alias.getResultado()).asc());
					} else {
						query.orderBy($(alias.getResultado()).desc());
					}
					break;
				case "fecha":
					if (next.isAscending()) {
						query.orderBy($(alias.getFecha()).asc());
					} else {
						query.orderBy($(alias.getFecha()).desc());
					}
					break;
				case "valorApostado":
					if (next.isAscending()) {
						query.orderBy($(alias.getValorApostado()).asc());
					} else {
						query.orderBy($(alias.getValorApostado()).desc());
					}
					break;
				case "valorGanado":
					if (next.isAscending()) {
						query.orderBy($(alias.getValorGanado()).asc());
					} else {
						query.orderBy($(alias.getValorGanado()).desc());
					}
					break;
				case "usuario":
					if (next.isAscending()) {
						query.orderBy($(alias.getUsuario().getId()).asc());
					} else {
						query.orderBy($(alias.getUsuario().getId()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}