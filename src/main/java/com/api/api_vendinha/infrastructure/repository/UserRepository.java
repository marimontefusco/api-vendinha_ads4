package com.api.api_vendinha.infrastructure.repository;

import com.api.api_vendinha.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

}
// especificar a entidade/classe que vai representar a tabela e o tipo do id -> User, Long
//User findFirstByName(String name);