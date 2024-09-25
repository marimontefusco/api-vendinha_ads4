package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.SaleRequestDto;
import com.api.api_vendinha.domain.dto.response.SaleResponseDto;
import com.api.api_vendinha.domain.entity.Sale;
import com.api.api_vendinha.infrastructure.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImplement implements SaleServiceInterface {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImplement(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    //POST
    @Override
    public SaleResponseDto saveSale(SaleRequestDto saleRequestDto) {

        Sale sale = new Sale();

        // Define a venda a partir do dto de request
        sale.setQuantity(saleRequestDto.getQuantity());
        sale.setPrice(saleRequestDto.getPrice());

        // Salva a venda no bd e obtém a entidade persistida com o id gerado
        Sale savedSale = saleRepository.save(sale);

        return createResponseDto(savedSale);
    }

    //UPDATE
    @Override
    public SaleResponseDto updateSale(Long id, SaleRequestDto saleRequestDto) {

        Sale saleExists = saleRepository.findById(id).orElseThrow();

        saleExists.setQuantity(saleRequestDto.getQuantity());
        saleExists.setPrice(saleRequestDto.getPrice());

        Sale savedSale = saleRepository.save(saleExists);

        return createResponseDto(savedSale);
    }

    //GET
    @Override
    public SaleResponseDto getSale(Long id) {

        Sale saleExists = saleRepository.findById(id).orElseThrow();

        return createResponseDto(saleExists);
    }

    //DELETE
    @Override
    public void deleteSale(Long id) {
        Sale saleExists = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("A venda de id " + id + " não foi encontrada."));

        saleRepository.deleteById(saleExists.getId());
    }

    // Função pra criar o saleResponseDto
    public SaleResponseDto createResponseDto(Sale sale) {

        SaleResponseDto saleResponseDto = new SaleResponseDto();

        saleResponseDto.setId(sale.getId());
        saleResponseDto.setQuantity(sale.getQuantity());
        saleResponseDto.setPrice(sale.getPrice());

        return saleResponseDto;
    }

}
