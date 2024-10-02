package com.api.api_vendinha.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleResponseDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Float price;
}
