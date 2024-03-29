/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



/**
 *
 * @author Ermishov
 */
public class Person {
    private int id;
    
    @NotEmpty(message="Name required!")
    @Size(min=2, max=30, message="Name shoulb be between 2 and 30 characters!")
    private String name;
    
    @Min(value = 0, message="Age should be grater than 0!")
    private int age;
    
    @NotEmpty(message="Email  should not be empty!")
    @Email(message="Email should be valid!")
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    public Person(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
