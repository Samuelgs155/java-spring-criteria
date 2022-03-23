package com.apring.jpa.criteria.repository;

import com.apring.jpa.criteria.model.Empleado;
import com.apring.jpa.criteria.model.EmpleadoPage;
import com.apring.jpa.criteria.model.EmpleadoSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmpleadoCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public EmpleadoCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Empleado> findAllWithFilters(EmpleadoPage empleadoPage,
                                             EmpleadoSearchCriteria empleadoSearchCriteria) {
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
        Root<Empleado> root = criteriaQuery.from(Empleado.class);

        Predicate predicate = getPredicate(empleadoSearchCriteria, root);
        criteriaQuery.where(predicate);
        setOrder(empleadoPage, criteriaQuery, root);

        TypedQuery<Empleado> typedQuery =  entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(empleadoPage.getPageNumber() * empleadoPage.getPageSize());
        typedQuery.setMaxResults(empleadoPage.getPageSize());

        Pageable pageable = getPageable(empleadoPage);

        long empleadosCount = getEmpleadosCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, empleadosCount);


    }

    private Predicate getPredicate(EmpleadoSearchCriteria empleadoSearchCriteria,
                                   Root<Empleado> root) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(empleadoSearchCriteria.getFirstName())) {
            predicates.add(
                    criteriaBuilder.like(root.get("firstName"),
                            "%" + empleadoSearchCriteria.getFirstName() + "%"));
        }
        if(Objects.nonNull(empleadoSearchCriteria.getLastName())) {
            predicates.add(
                    criteriaBuilder.like(root.get("lastName"),
                            "%" + empleadoSearchCriteria.getLastName() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

    }

    private void setOrder(EmpleadoPage empleadoPage,
                          CriteriaQuery<Empleado> criteriaQuery,
                          Root<Empleado> root) {
        if(empleadoPage.getSoDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(empleadoPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(empleadoPage.getSortBy())));
        }
    }

    private Pageable getPageable(EmpleadoPage empleadoPage) {
        Sort sort = Sort.by(empleadoPage.getSoDirection(), empleadoPage.getSortBy());
        return PageRequest.of(empleadoPage.getPageNumber(),
                empleadoPage.getPageSize(),
                sort);
    }

    private long getEmpleadosCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Empleado> countRoot =  countQuery.from(Empleado.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
