package com.cursocodemin.codemin.repositories;

import com.cursocodemin.codemin.models.Person;
import com.cursocodemin.codemin.specifications.UserSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    List<Person> findByName(@Param("name") String name);

}
