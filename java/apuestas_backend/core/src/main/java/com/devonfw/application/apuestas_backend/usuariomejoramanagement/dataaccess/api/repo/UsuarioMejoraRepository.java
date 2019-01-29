package com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.apuestas_backend.usuariomejoramanagement.dataaccess.api.UsuarioMejoraEntity;
import com.devonfw.application.apuestas_backend.usuariomejoramanagement.logic.api.to.UsuarioMejoraSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link UsuarioMejoraEntity}
 */
public interface UsuarioMejoraRepository extends DefaultRepository<UsuarioMejoraEntity> {

	/**
	 * @param criteria    the {@link UsuarioMejoraSearchCriteriaTo} with the
	 *                    criteria to search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link UsuarioMejoraEntity} objects that
	 *         matched the search.
	 */
	default Page<UsuarioMejoraEntity> findByCriteria(UsuarioMejoraSearchCriteriaTo criteria) {

		UsuarioMejoraEntity alias = newDslAlias();
		JPAQuery<UsuarioMejoraEntity> query = newDslQuery(alias);

		Long usuario = criteria.getUsuarioId();
		if (usuario != null) {
			query.where($(alias.getUsuario().getId()).eq(usuario));
		}
		Long mejora = criteria.getMejoraId();
		if (mejora != null) {
			query.where($(alias.getMejora().getId()).eq(mejora));
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
	public default void addOrderBy(JPAQuery<UsuarioMejoraEntity> query, UsuarioMejoraEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "usuario":
					if (next.isAscending()) {
						query.orderBy($(alias.getUsuario().getId()).asc());
					} else {
						query.orderBy($(alias.getUsuario().getId()).desc());
					}
					break;
				case "mejora":
					if (next.isAscending()) {
						query.orderBy($(alias.getMejora().getId()).asc());
					} else {
						query.orderBy($(alias.getMejora().getId()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}