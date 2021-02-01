/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcproject.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ermishov
 */
@Controller
public class FirstController {
    
    @GetMapping("/hello")
    public String helloPage(@RequestParam("name")String name, 
                            @RequestParam("surname")String surname,
                             Model model){
        model.addAttribute("message", "Name: " + name + " \nSurname: " + surname);
        return ("/first/hello");
    }
    
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return("/first/goodbye");
    }    
    
    @GetMapping("/calc")
    public String calc(@RequestParam("a") float a,
            @RequestParam("b") float b,
            @RequestParam("action") String action,
            Model model) {
        double result = 0;
        switch (action) {
            case ("additional"):
                result = a + b;
                break;
            case ("substraction"):
                result = a - b;
                break;
            case ("multiplacation"):
                result = a * b;
                break;
            case ("divison"):
                result = a / b;
                break;
        }
        model.addAttribute("result", result);
        return "/first/calculator";
    }
}
