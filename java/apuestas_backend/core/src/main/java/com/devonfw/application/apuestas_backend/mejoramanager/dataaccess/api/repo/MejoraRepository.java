package com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.apuestas_backend.mejoramanager.dataaccess.api.MejoraEntity;
import com.devonfw.application.apuestas_backend.mejoramanager.logic.api.to.MejoraSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link MejoraEntity}
 */
public interface MejoraRepository extends DefaultRepository<MejoraEntity> {

	/**
	 * @param criteria    the {@link MejoraSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link MejoraEntity} objects that matched the
	 *         search.
	 */
	default Page<MejoraEntity> findByCriteria(MejoraSearchCriteriaTo criteria) {

		MejoraEntity alias = newDslAlias();
		JPAQuery<MejoraEntity> query = newDslQuery(alias);

		String descripcion = criteria.getDescripcion();
		if (descripcion != null && !descripcion.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getDescripcion()), descripcion, criteria.getDescripcionOption());
		}
		Long tipoMejora = criteria.getTipoMejoraId();
		if (tipoMejora != null) {
			query.where($(alias.getTipoMejora().getId()).eq(tipoMejora));
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
	public default void addOrderBy(JPAQuery<MejoraEntity> query, MejoraEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "descripcion":
					if (next.isAscending()) {
						query.orderBy($(alias.getDescripcion()).asc());
					} else {
						query.orderBy($(alias.getDescripcion()).desc());
					}
					break;
				case "tipoMejora":
					if (next.isAscending()) {
						query.orderBy($(alias.getTipoMejora().getId()).asc());
					} else {
						query.orderBy($(alias.getTipoMejora().getId()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}