package com.cursocodemin.codemin.services;

import com.cursocodemin.codemin.models.Person;
import com.cursocodemin.codemin.repositories.PersonRepository;
import com.cursocodemin.codemin.specifications.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findPerson(String name, String username){
        UserSpecification spec = new UserSpecification(name, username);
        return personRepository.findAll(spec);
    }

}
