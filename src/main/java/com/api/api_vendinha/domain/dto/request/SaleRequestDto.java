package com.api.api_vendinha.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleRequestDto {
    private Integer quantity;
    private Float price;
}
