package com.demo.services.impl;

import com.demo.entities.Person;
import com.demo.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;


    @Test
    void testSavePerson(){

        Person person = new Person();
        person.setName("pedro");


        Person result = personRepository.save(person);
        assertNotNull(result);
        assertEquals(person.getName(), result.getName());
        assertEquals(person.getId(), result.getId());


    }

    @Test
    void testFindPerson(){


        String name = "pedro";

        testSavePerson();

        List<Person> result = personRepository.findByName(name);
        assertNotNull(result);
        assertEquals(name, result.get(0).getName());

    }


    @Test
    void testFindPerson_nothingFound(){


        String name = "Pedro";

        testSavePerson();

        List<Person> result = personRepository.findByName(name);
        assertTrue(result.size() == 0);


    }

}
