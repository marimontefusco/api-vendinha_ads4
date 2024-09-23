package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.ProductRequestDto;
import com.api.api_vendinha.domain.dto.response.ProductResponseDto;
import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplement implements ProductServiceInterface {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // POST
    @Override
    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto) {

        // nova instância de Product
        Product product = new Product();

        // Define o produto a partir do dto de request
        product.setName(productRequestDto.getName());
        product.setQuantity(productRequestDto.getQuantity());
        product.setPrice(productRequestDto.getPrice());
        product.setIsActive(productRequestDto.getIsActive());

        // Salva o produto no bd e obtém a entidade persistida com o id gerado
        Product savedProduct = productRepository.save(product);

        return getProductDto(savedProduct);
    }

    // UPDATE
    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        // Verificar se produto existe
        Product productExists = productRepository.findById(id).orElseThrow();

        productExists.setName(productRequestDto.getName());
        productExists.setQuantity(productRequestDto.getQuantity());
        productExists.setPrice(productRequestDto.getPrice());
        productExists.setIsActive(productRequestDto.getIsActive());

        // Atualiza os dados e salva no bd
        Product savedProduct = productRepository.save(productExists);

        return getProductDto(savedProduct);
    }

    // GET
    @Override
    public ProductResponseDto getProduct(Long id) {

        //Verifica se o Product existe
        Product productExists = productRepository.findById(id).orElseThrow();

        // Retorna o DTO com as infos do usuario encontrado
        return getProductDto(productExists);
    }

    // SET STATUS -
    @Override
    public ProductResponseDto setActiveStatus(Long id, ProductRequestDto productRequestDto) {

        //Verifica se o Product existe
        Product productExists = productRepository.findById(id).orElseThrow();

        productExists.setIsActive(productRequestDto.getIsActive());
        productRepository.save(productExists);

        // Retorna o DTO com as infos do usuario encontrado
        return  getProductDto(productExists);
    }

    // Função pra retornar o productResponseDto
    private ProductResponseDto getProductDto(Product product) {

        // Cria um Dto de resposta com as infos do produto salvo
        ProductResponseDto productResponseDto = new ProductResponseDto();

        // Seta os atributos da resposta do Dto
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setQuantity(product.getQuantity());
        productResponseDto.setPrice(product.getPrice());

        return productResponseDto;
    }
}
