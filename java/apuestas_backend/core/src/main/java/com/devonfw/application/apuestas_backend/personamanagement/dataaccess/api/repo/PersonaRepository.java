package com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.apuestas_backend.personamanagement.dataaccess.api.PersonaEntity;
import com.devonfw.application.apuestas_backend.personamanagement.logic.api.to.PersonaSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link PersonaEntity}
 */
public interface PersonaRepository extends DefaultRepository<PersonaEntity> {

	/**
	 * @param criteria    the {@link PersonaSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link PersonaEntity} objects that matched
	 *         the search.
	 */
	default Page<PersonaEntity> findByCriteria(PersonaSearchCriteriaTo criteria) {

		PersonaEntity alias = newDslAlias();
		JPAQuery<PersonaEntity> query = newDslQuery(alias);

		String nombre = criteria.getNombre();
		if (nombre != null && !nombre.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getNombre()), nombre, criteria.getNombreOption());
		}
		Timestamp fechaNacimiento = criteria.getFechaNacimiento();
		if (fechaNacimiento != null) {
			query.where($(alias.getFechaNacimiento()).eq(fechaNacimiento));
		}
		String email = criteria.getEmail();
		if (email != null && !email.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getEmail()), email, criteria.getEmailOption());
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
	public default void addOrderBy(JPAQuery<PersonaEntity> query, PersonaEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "nombre":
					if (next.isAscending()) {
						query.orderBy($(alias.getNombre()).asc());
					} else {
						query.orderBy($(alias.getNombre()).desc());
					}
					break;
				case "fechaNacimiento":
					if (next.isAscending()) {
						query.orderBy($(alias.getFechaNacimiento()).asc());
					} else {
						query.orderBy($(alias.getFechaNacimiento()).desc());
					}
					break;
				case "email":
					if (next.isAscending()) {
						query.orderBy($(alias.getEmail()).asc());
					} else {
						query.orderBy($(alias.getEmail()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}