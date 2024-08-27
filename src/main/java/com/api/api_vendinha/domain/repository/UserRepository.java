package com.api.api_vendinha.domain.repository;

import com.api.api_vendinha.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Object> findById(Long id);

}

//User findFirstByName(String name);