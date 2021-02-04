/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.dao;

import java.util.List;
import com.mycompany.springmvcproject.models.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ermishov
 */
@Component
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Person> index() {
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) throws SQLException {
       return jdbcTemplate.query("select * from Person where id=?",new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class))
               .stream().findAny().orElse(null);
    }

    public void save(Person person) {
       jdbcTemplate.update("insert into Person values(1, ?, ?,?)", person.getName(),
           person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson) throws SQLException {
        
        jdbcTemplate.update("update Person set name=?, age=?, email=? where id=?", updatedPerson.getName(),
           updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
            jdbcTemplate.update("delete from Person where id=?", id);

    }
}
