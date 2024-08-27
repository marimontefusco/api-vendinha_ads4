package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.UserRequestDto;
import com.api.api_vendinha.domain.dto.UserResponseDto;

public interface UserServiceInterface {

    // Definição dos métodos q a Service terá que implementar
    UserResponseDto saveUser(UserRequestDto userRequestDto);


    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
}
