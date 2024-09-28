package com.api.api_vendinha.controller;

import com.api.api_vendinha.domain.dto.request.SaleRequestDto;
import com.api.api_vendinha.domain.dto.response.SaleResponseDto;
import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.domain.service.ProductServiceInterface;
import com.api.api_vendinha.domain.service.SaleServiceInterface;
import com.api.api_vendinha.infrastructure.repository.ProductRepository;
import com.api.api_vendinha.infrastructure.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleServiceInterface saleService;
    private final ProductServiceInterface productService;

    @Autowired
    public SaleController(SaleServiceInterface saleService, ProductServiceInterface productService) {
        this.saleService = saleService;
        this.productService = productService;
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
