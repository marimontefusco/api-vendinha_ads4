package com.api.api_vendinha.controller;

import com.api.api_vendinha.domain.dto.UserRequestDto;
import com.api.api_vendinha.domain.dto.UserResponseDto;
import com.api.api_vendinha.domain.entity.User;
import com.api.api_vendinha.domain.service.UserServiceInterface;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //variável para injeção de dependencia do UserService
    private final UserServiceInterface userService;

    // Construtor -> p a injeção de depend do UserService
    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    // Métodos CRUD
    // POST
    @PostMapping("/salvar")
    public UserResponseDto saveUser(@RequestBody UserRequestDto userRequestDto) {
        return this.userService.saveUser(userRequestDto);
        //chama o Service p salvar o usuário e retornar a response
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
        //chama o Service para salvar o usuário ee retorna a resposta
    }


}
