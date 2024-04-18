package com.icekiwi.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icekiwi.banking.models.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
