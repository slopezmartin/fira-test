package com.demo.services.impl;

import com.demo.entities.Person;
import com.demo.exceptions.PersonException;
import com.demo.repositories.PersonRepository;
import com.demo.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
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


    /*Cuando recibo Pedro se busca en base de datos y devuelve el listado de personas con nombre Pedro

    Cuando recibo pedro se devuelve el listado de personas con nombre Pedro

    Cuando recibo PEDRO se devuelve el listado de personas con nombre Pedro

    Cuando recibo Anna se devuelve un listado de personas vacío

    Cuando recibo "" se devuelve un listado de personas vacío

    Cuando recibo un null se devuelve un error con el mensaje "Se ha de especificar un nombre"*/

    @Test
    void testGetByName_nameIsPedro_OK() throws PersonException {

        String name = "Pedro";

        Person personBBDD = new Person();
        personBBDD.setName(name);

        when(personRepository.findByNameIgnoreCase(name)).thenReturn(Arrays.asList(personBBDD));
        List<Person> result = personService.getByName(name);

        assertNotNull(result);
        assertNotNull(result.get(0));
        assertEquals(name, result.get(0).getName());

        verify(personRepository).findByNameIgnoreCase(name);
        verifyNoMoreInteractions(personRepository);
    }



    @Test
    void testGetByName_nameIspedro_OK() throws PersonException {

        String name = "pedro";

        Person personBBDD = new Person();
        personBBDD.setName("Pedro");

        when(personRepository.findByNameIgnoreCase(name)).thenReturn(Arrays.asList(personBBDD));
        List<Person> result = personService.getByName(name);

        assertNotNull(result);
        assertNotNull(result.get(0));
        assertEquals("Pedro", result.get(0).getName());

        verify(personRepository).findByNameIgnoreCase(name);
        verifyNoMoreInteractions(personRepository);
    }

    @Test
    void testGetByName_nameIsNull_throwError() {

        String name = null;

        assertThrows(PersonException.class, ()-> personService.getByName(name), "Se ha de especificar un nombre");

    }
}
