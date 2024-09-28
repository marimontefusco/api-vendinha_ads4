package com.api.api_vendinha.controller;

import com.api.api_vendinha.domain.dto.request.SaleRequestDto;
import com.api.api_vendinha.domain.dto.response.SaleResponseDto;
import com.api.api_vendinha.domain.service.SaleServiceInterface;
import com.api.api_vendinha.infrastructure.repository.ProductRepository;
import com.api.api_vendinha.infrastructure.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleServiceInterface saleService;
    private final ProductRepository productRepository;

    @Autowired
    public SaleController(SaleServiceInterface saleService, ProductRepository productRepository) {
        this.saleService = saleService;
        this.productRepository = productRepository;
    }

    // Métodos:
    // POST
    @PostMapping("/save")
    public SaleResponseDto saveSale(@RequestBody SaleRequestDto saleRequestDto) {
        return saleService.saveSale(saleRequestDto);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public SaleResponseDto updateSale(@PathVariable Long id,
                                      @RequestBody SaleRequestDto saleRequestDto) {
        return saleService.updateSale(id, saleRequestDto);
    }

    // GET
    @GetMapping("/search/{id}")
    public SaleResponseDto getSale(@PathVariable Long id) {
        return saleService.getSale(id);
    }

    // DELETE
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id)  {
        saleService.deleteSale(id);
        return ResponseEntity.ok("Venda deletada com sucesso.");
    }

}
