package com.example.ncc1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class HomeController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public String toHomePage() {
        return "";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public String showLoginPage(){
        return "security/myLogin";
    }
}
