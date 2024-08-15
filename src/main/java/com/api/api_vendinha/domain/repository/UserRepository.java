package com.api.api_vendinha.domain.repository;

import com.api.api_vendinha.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

//User findFirstByName(String name);