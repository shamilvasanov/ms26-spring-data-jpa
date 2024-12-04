package com.example.taxidrivers.service.specification;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.model.criteria.DriverCriteria;
import com.example.taxidrivers.util.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.example.taxidrivers.model.constants.CriteriaConstants.AGE;
import static com.example.taxidrivers.model.constants.CriteriaConstants.CATEGORY;
import static com.example.taxidrivers.util.PredicateUtil.applyLikePattern;

@AllArgsConstructor
public class DriverSpecification implements Specification<DriverEntity> {
    private DriverCriteria driverCriteria;
    @Override
    public Predicate toPredicate(Root<DriverEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = PredicateUtil.builder()
                .addNullSafety(driverCriteria.getCategory(),
                        category ->  cb.like(root.get(CATEGORY),applyLikePattern(category)))
                .addNullSafety(driverCriteria.getAgeFrom(),
                        ageFrom ->  cb.greaterThanOrEqualTo(root.get(AGE),ageFrom))
                .addNullSafety(driverCriteria.getAgeTo(),
                        ageTo ->  cb.lessThanOrEqualTo(root.get(AGE),ageTo))
                .build();
        return cb.and(predicates);
    }
}
