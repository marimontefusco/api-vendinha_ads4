package com.api.api_vendinha.domain.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
    private Boolean is_active;
}
