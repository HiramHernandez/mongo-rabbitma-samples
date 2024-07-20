package com.cursocodemin.codemin.specifications;

import com.cursocodemin.codemin.models.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<Person> {
    private String name;
    private String userName;

    public UserSpecification(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        }

        if (userName != null) {
            predicates.add(criteriaBuilder.equal(root.get("userName"), userName));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
