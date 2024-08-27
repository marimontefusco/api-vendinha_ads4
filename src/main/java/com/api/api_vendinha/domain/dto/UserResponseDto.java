package com.api.api_vendinha.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
}
