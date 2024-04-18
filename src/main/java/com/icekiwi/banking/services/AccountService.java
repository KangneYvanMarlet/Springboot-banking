package com.icekiwi.banking.services;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.icekiwi.banking.models.Account;
import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.models.User;
import com.icekiwi.banking.repositories.AccountRepository;
import com.icekiwi.banking.repositories.OperationRepository;

import lombok.AllArgsConstructor;

// service for account management 
@Service
@AllArgsConstructor
public class AccountService {

    final private AccountRepository accountRepository;
    final private OperationRepository operationRepository;

    // send money from account to another one
    public void send(String senderId, String recipientId, Double value) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account operator = accountRepository.getReferenceById(senderId);
        Account recipient = accountRepository.getReferenceById(recipientId);

        Double newOperatorvalue = operator.getValue() - value;
        operator.setValue(newOperatorvalue);
        recipient.setValue(recipient.getValue() + value);

        Operation operation = new Operation();

        operation.setValue(value);
        operation.setType("transaction");
        operation.setOperator(operator);
        operation.setRecipient(recipient);
        operation.setUser(user);

        operationRepository.save(operation);
        accountRepository.save(operator);
        accountRepository.save(recipient);
    }

    // service for cash out operation
    public void cashOut(String id, Double value) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account operator = accountRepository.findById(id).orElseThrow();
        Operation operation = new Operation();
        operation.setOperator(operator);
        operation.setType("withdraw");
        operation.setUser(user);
        operation.setValue(value);
        operator.setValue(operator.getValue() - value);
        operationRepository.save(operation);
        accountRepository.save(operator);
    }

    // cash in operation
    public void CashIn(String id, Double value) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account operator = accountRepository.findById(id).orElseThrow();
        Operation operation = new Operation();
        operation.setOperator(operator);
        operation.setType("deposit");
        operation.setUser(user);
        operation.setValue(value);
        operator.setValue(value + operator.getValue());
        operationRepository.save(operation);
        accountRepository.save(operator);

    }

    // list all accounts
    public List<Account> listAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    // get an account by its id
    public Account getAccount(String id) {
        Account account = accountRepository.findById(id).orElseThrow();
        return account;
    }
}
