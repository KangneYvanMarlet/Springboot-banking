package com.icekiwi.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.models.User;
import java.util.Date;

public interface OperationRepository extends JpaRepository<Operation, String> {
    long countByUser(User user);

    long countByUserAndCreationDate(User user, Date creationDate);

}
