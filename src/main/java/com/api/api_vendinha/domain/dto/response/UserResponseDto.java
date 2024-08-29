package com.api.api_vendinha.domain.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
    private Boolean is_active;
}
