package com.api.api_vendinha.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer quantity;
    private Float price;
}

//private Boolean isActive;