package com.api.api_vendinha.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    // Métodos CRUD

    // POST
    @PostMapping("/user")
    public String saveUser() {
        return "User saved!";
    }

}
