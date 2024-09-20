package com.api.api_vendinha.controller;

import com.api.api_vendinha.domain.dto.request.ProductRequestDto;
import com.api.api_vendinha.domain.dto.response.ProductResponseDto;
import com.api.api_vendinha.domain.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceInterface productService;

    @Autowired
    public ProductController(ProductServiceInterface productService) {
        this.productService = productService;
    }

    // POST
    @PostMapping("/save")
    public ProductResponseDto saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.saveProduct(productRequestDto);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id,
                                            @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    // GET
    @GetMapping("search/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

}
