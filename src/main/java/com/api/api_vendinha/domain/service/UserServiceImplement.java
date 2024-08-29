package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.UserRequestDto;
import com.api.api_vendinha.domain.dto.response.UserResponseDto;
import com.api.api_vendinha.domain.entity.User;
import com.api.api_vendinha.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserServiceInterface {

    // variável do userRepository para persistência de dados de usuários
    private final UserRepository userRepository;

    // Construtor p injeção de depend do UserRepository
    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método saveUser
    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {

        User user = new User();

        //Define o nome do usuário a partir do Dto
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCpf_cnpj(userRequestDto.getCpf_cnpj());
        user.setIs_active(userRequestDto.getIs_active());

        // Salva o usuário no bd e obtém a entidade persistida com o id gerado
        User savedUser = userRepository.save(user);

        // Cria um Dto de resposta com as infos do usuário salvo
        UserResponseDto userResponseDto = new UserResponseDto();
            // novo obj do tipo UserResponseDto

        userResponseDto.setId(savedUser.getId());
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setCpf_cnpj(savedUser.getCpf_cnpj());
        userResponseDto.setIs_active(savedUser.getIs_active());

        // Retorna o Dto com as infos do usuário salvo
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {

        // Verifica se o usuário existe
        User userExists = (User) userRepository.findById(id).orElseThrow();

        userExists.setName(userRequestDto.getName());
        userExists.setEmail(userRequestDto.getEmail());
        userExists.setPassword(userRequestDto.getPassword());
        userExists.setCpf_cnpj(userRequestDto.getCpf_cnpj());

        // Atualiza os dados e salva no bd
        userRepository.save(userExists);

        // Cria um Dto de resposta com as infos do usuário salvo
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(userExists.getId());
        userResponseDto.setName(userExists.getName());
        userResponseDto.setEmail(userExists.getEmail());
        userResponseDto.setPassword(userExists.getPassword());
        userResponseDto.setCpf_cnpj(userExists.getCpf_cnpj());

        // Retorna o Dto com as infos do usuário salvo
        return userResponseDto;
    }

}





