package com.jberdeja.relational_database_administrator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jberdeja.relational_database_administrator.entity.Person;
import com.jberdeja.relational_database_administrator.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll(){
        return personRepository.findAll();
    } 

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person update(Long dni, Person person){
        Person persontoUpdate = personFindByDni(dni);

        persontoUpdate.setName(person.getName());
        persontoUpdate.setLastname(person.getLastname());
        persontoUpdate.setAge(person.getAge());
        persontoUpdate.setDni(person.getDni());

        personRepository.save(persontoUpdate);

        return persontoUpdate;
    }

    public Person delete(Long dni){
        Person persontoDelete = personFindByDni(dni);
        personRepository.delete(persontoDelete);
        return persontoDelete;
    }

    private Person personFindByDni(Long dni){
        return personRepository.findByDni(dni).stream().findFirst().orElseThrow(() -> new RuntimeException("Person not found DNI " + dni));
    }
}
