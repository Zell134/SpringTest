/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.models;

/**
 *
 * @author Ermishov
 */
public class Person {
    private int id;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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
    private String name;
}
