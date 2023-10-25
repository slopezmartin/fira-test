package com.demo.services.impl;

import com.demo.entities.Person;
import com.demo.exceptions.PersonException;
import com.demo.repositories.PersonRepository;
import com.demo.services.PersonService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getByName(String name) throws PersonException {

        if(null == name){
            throw new PersonException("Se ha de especificar un nombre");
        }
        return personRepository.findByNameIgnoreCase(name);
    }
}
