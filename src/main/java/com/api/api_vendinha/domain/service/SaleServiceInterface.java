package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.SaleRequestDto;
import com.api.api_vendinha.domain.dto.response.SaleResponseDto;

public interface SaleServiceInterface {

    SaleResponseDto saveSale(SaleRequestDto saleRequestDto);

    SaleResponseDto updateSale(Long id, SaleRequestDto saleRequestDto);

    SaleResponseDto getSale(Long id);

    void deleteSale(Long id);
}
