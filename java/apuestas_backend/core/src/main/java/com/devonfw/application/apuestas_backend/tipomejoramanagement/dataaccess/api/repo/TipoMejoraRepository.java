package com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.apuestas_backend.tipomejoramanagement.dataaccess.api.TipoMejoraEntity;
import com.devonfw.application.apuestas_backend.tipomejoramanagement.logic.api.to.TipoMejoraSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link TipoMejoraEntity}
 */
public interface TipoMejoraRepository extends DefaultRepository<TipoMejoraEntity> {

	/**
	 * @param criteria    the {@link TipoMejoraSearchCriteriaTo} with the criteria
	 *                    to search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link TipoMejoraEntity} objects that matched
	 *         the search.
	 */
	default Page<TipoMejoraEntity> findByCriteria(TipoMejoraSearchCriteriaTo criteria) {

		TipoMejoraEntity alias = newDslAlias();
		JPAQuery<TipoMejoraEntity> query = newDslQuery(alias);

		String descripcion = criteria.getDescripcion();
		if (descripcion != null && !descripcion.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getDescripcion()), descripcion, criteria.getDescripcionOption());
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
	public default void addOrderBy(JPAQuery<TipoMejoraEntity> query, TipoMejoraEntity alias, Sort sort) {
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
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}