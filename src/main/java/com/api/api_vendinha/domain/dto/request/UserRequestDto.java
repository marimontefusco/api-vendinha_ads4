package com.api.api_vendinha.domain.dto.request;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
    private Boolean is_active;

    private List<ProductRequestDto> productRequestDto;
    private List<SaleRequestDto> saleRequestDto;

}

//private List<SaleRequestDto> saleRequestDto;