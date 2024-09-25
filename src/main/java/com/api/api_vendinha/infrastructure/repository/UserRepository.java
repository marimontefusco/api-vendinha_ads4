package com.api.api_vendinha.infrastructure.repository;

import com.api.api_vendinha.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
                                    // <entidade que representa a tb, tipo do id>

    Optional<User> findById(Long id);
    //retorna um Optional contendo o usuário encontrado
    // ou um Optional vazio se o user não existir

    //User findFirstByName(String name);

}


