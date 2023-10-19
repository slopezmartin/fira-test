package com.demo.services;

import com.demo.entities.Person;

import java.util.List;

public interface PersonService {
    List<Person> getByName(String name);
}
