package com.demo.services;

import com.demo.entities.Person;
import com.demo.exceptions.PersonException;

import java.util.List;

public interface PersonService {
    List<Person> getByName(String name) throws PersonException;
}
