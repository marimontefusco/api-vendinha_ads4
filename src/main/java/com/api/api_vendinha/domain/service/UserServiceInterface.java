package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.UserRequestDto;
import com.api.api_vendinha.domain.dto.response.UserResponseDto;

public interface UserServiceInterface {

    // Contrato -> Definição dos métodos q a Service terá que implementar
    UserResponseDto saveUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);

    UserResponseDto setUserStatus(Long id, UserRequestDto is_active);

    UserResponseDto getUser(Long id);

    void deleteUser(Long id);

}


