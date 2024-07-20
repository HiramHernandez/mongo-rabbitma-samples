package com.cursocodemin.codemin.controllers;

import java.util.List;

import com.cursocodemin.codemin.models.Person;
import com.cursocodemin.codemin.repositories.PersonRepository;
import com.cursocodemin.codemin.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> allPerson(){
        List<Person> results = personService.findPerson("hiram", "hirammx");
        return personRepository.findAll();
        //return results;
    }

    @GetMapping("/person/{name}")
    public List<Person> findByName(@PathVariable("name") String name) {
        return personRepository.findByName(name);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {

        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id ,@RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
    }


}
