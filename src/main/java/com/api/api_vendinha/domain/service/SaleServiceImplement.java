package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.SaleRequestDto;
import com.api.api_vendinha.domain.dto.response.SaleResponseDto;
import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.domain.entity.Sale;
import com.api.api_vendinha.domain.entity.User;
import com.api.api_vendinha.infrastructure.repository.ProductRepository;
import com.api.api_vendinha.infrastructure.repository.SaleRepository;
import com.api.api_vendinha.infrastructure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImplement implements SaleServiceInterface {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public SaleServiceImplement(SaleRepository saleRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    //POST
    @Override
    public SaleResponseDto saveSale(SaleRequestDto saleRequestDto) {

        // Cria uma nova venda
        Sale sale = new Sale();

        // Verifica se o usuário existe
        User user = userRepository.findById(saleRequestDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Verifica se o produto existe
        Product product = productRepository.findById(saleRequestDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        // Verifica se a qntidade pedida está disponível no estoque
        if (product.getQuantity() < saleRequestDto.getQuantity()) {
            throw new IllegalArgumentException(("Estoque insuficiente do produto: " + product.getName()));
        }

        // Subtrai qntidade vendida e atualiza o estoque depois da venda
        product.setQuantity(product.getQuantity() - saleRequestDto.getQuantity());
        productRepository.save(product);

        // Define a venda a partir do dto de request
        sale.setUser(userRepository.findById(saleRequestDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado")));
        sale.setProduct(product);
        sale.setQuantity(saleRequestDto.getQuantity());
        sale.setPrice(product.getPrice() * saleRequestDto.getQuantity());
                    // P.final = P.unidade * qntidade

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
