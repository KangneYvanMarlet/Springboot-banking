package com.icekiwi.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.repositories.OperationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;

    // get all operations
    public List<Operation> getOperations() {

        List<Operation> operations = operationRepository.findAll();
        return operations;
    }

    // get information abpout a single operation
    public Operation getOperationInfo(String id) {
        Operation operation = operationRepository.getReferenceById(id);
        return operation;
    }

}
