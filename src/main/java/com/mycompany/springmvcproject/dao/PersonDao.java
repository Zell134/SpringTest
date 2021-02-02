/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.dao;

import java.util.List;
import com.mycompany.springmvcproject.models.Person;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ermishov
 */
@Component
public class PersonDao {
    private List<Person> people;
    private static int PEOPLE_COUNT = 0;
    {
        people = new ArrayList<>();
        people.add(new Person( ++PEOPLE_COUNT, "name1"));
        people.add(new Person( ++PEOPLE_COUNT, "name2"));
        people.add(new Person( ++PEOPLE_COUNT, "name3"));
        people.add(new Person( ++PEOPLE_COUNT, "name4"));
    }
    
    public List<Person> index(){
        return people;
    }
    
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
    
    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
