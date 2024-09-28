package com.api.api_vendinha.domain.dto.request;

import com.api.api_vendinha.domain.entity.Sale;
import com.api.api_vendinha.domain.entity.User;
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

    private User user;
    private List<Sale> saleRequestDto;
}
