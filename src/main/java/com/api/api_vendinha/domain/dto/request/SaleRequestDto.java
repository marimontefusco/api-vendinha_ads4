package com.api.api_vendinha.domain.dto.request;

import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleRequestDto {
    private User user;
    private Integer quantity;
    private Float price;


//    private List<ProductRequestDto> product_id;
}
