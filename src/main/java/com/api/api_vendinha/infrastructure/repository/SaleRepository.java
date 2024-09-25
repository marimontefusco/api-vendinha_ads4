package com.api.api_vendinha.infrastructure.repository;

import com.api.api_vendinha.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findById(Long id);

    void delete(Sale saleExists);
}
