package com.icekiwi.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icekiwi.banking.models.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByMatricule(String username);

}
