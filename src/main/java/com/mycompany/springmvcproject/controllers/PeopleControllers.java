/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.controllers;

import com.mycompany.springmvcproject.dao.PersonDao;
import com.mycompany.springmvcproject.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ermishov
 */
@Controller
@RequestMapping("/people")
public class PeopleControllers {
    
    private PersonDao personDao;
    
    @Autowired
    public void PeopleController(PersonDao personDao){
        this.personDao = personDao;
    }
    
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDao.index());
        return "people/index";
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
    
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }
    
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDao.save(person);
        return "redirect:/people";
    }
    
    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDao.show(id));
        return "people/edit";
    }
    
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDao.update(id, person);
        return "redirect:/people";
    }
    
    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id){
        personDao.delete(id);
        return "redirect:/people";
    }
}
