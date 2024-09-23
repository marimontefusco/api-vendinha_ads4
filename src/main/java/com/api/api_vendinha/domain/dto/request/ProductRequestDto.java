package com.api.api_vendinha.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDto {
    private String name;
    private Integer quantity;
    private Float price;
    private Boolean isActive;
}
