package com.api.api_vendinha.controller;

import com.api.api_vendinha.domain.dto.request.UserRequestDto;
import com.api.api_vendinha.domain.dto.response.UserResponseDto;
import com.api.api_vendinha.domain.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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
    @PostMapping("/user/salvar")
    public UserResponseDto saveUser(@RequestBody UserRequestDto userRequestDto) {
        return this.userService.saveUser(userRequestDto);
        //chama o Service p salvar o usuário e retornar a response
    }

    // UPDATE
    @PutMapping("/user/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
        //chama o Service para salvar o usuário e  retorna a resposta
    }

}

//ORM hibernate -> mapeamento de objeto relacional -> pra gente nao precisar escrever sql puro
//mapeia a consulta feita em java e transforma em SQL
//ex: funcao save() do Java -> transforma em INSERT do SQL

//payload ->> o corpo da sua requisição
//é a info q vai ser enviada para fazer a requisição