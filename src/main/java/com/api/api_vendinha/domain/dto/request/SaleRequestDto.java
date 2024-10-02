package com.api.api_vendinha.domain.dto.request;

import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleRequestDto {
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Float price;
}
