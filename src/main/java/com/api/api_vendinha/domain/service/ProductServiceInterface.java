package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.ProductRequestDto;
import com.api.api_vendinha.domain.dto.response.ProductResponseDto;

public interface ProductServiceInterface {

    ProductResponseDto saveProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    ProductResponseDto getProduct(Long id);

    // SET STATUS:
    ProductResponseDto setActiveStatus(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);
}
