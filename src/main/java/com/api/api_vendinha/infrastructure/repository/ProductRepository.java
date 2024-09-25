package com.api.api_vendinha.infrastructure.repository;

import com.api.api_vendinha.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
        //retorna um Optional contendo o usuário encontrado
        // ou um Optional vazio se o user não existir

    void delete(Product productExists);

}
