package com.demo.services.impl;


import com.demo.entities.Person;
import com.demo.repositories.PersonRepository;
import com.demo.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService = new PersonServiceImpl(personRepository);

    @BeforeEach
    void setUp(){
        initMocks(this);
    }

    @Test
    void getByName_OK() {

        String name = "Pedro";
        Person person = new Person();
        person.setName(name);

        when(personRepository.findByName(name)).thenReturn(Arrays.asList(person));
        List<Person> result =  personService.getByName(name);

        assertEquals(name , result.get(0).getName());
        verify(personRepository).findByName(name);
        verifyNoMoreInteractions(personRepository);

    }


    @Test
    void getByName_nothingFound() {

        String name = "Pedro";

        when(personRepository.findByName(name)).thenReturn(null);
        List<Person> result =  personService.getByName(name);

        assertNull(result);
        verify(personRepository).findByName(name);
        verifyNoMoreInteractions(personRepository);

    }

    @Test
    void getByName_nameOnLowerCase() {

        String name = "pedro";

        Person person = new Person();
        person.setName("Pedro");

        when(personRepository.findByName(name)).thenReturn(null);
        List<Person> result =  personService.getByName(name);

        assertEquals(name , result.get(0).getName());
        verify(personRepository).findByName(name);
        verifyNoMoreInteractions(personRepository);

    }

}
