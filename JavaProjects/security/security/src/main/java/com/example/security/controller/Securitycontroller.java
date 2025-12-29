package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Securitycontroller {
    @GetMapping("/home")
    public String homePage(){
        return "you are on homee page";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "you are on adminPage";
    }
}
