package com.icekiwi.banking.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icekiwi.banking.dto.TransactionRequestDto;
import com.icekiwi.banking.models.Account;
import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.services.AccountService;

import lombok.AllArgsConstructor;

@RequestMapping("accounts")
@Controller
@AllArgsConstructor
public class AccountController {

    final private AccountService accountService;

    @GetMapping
    public String accounts(Model model) {
        List<Account> accounts = accountService.listAccounts();
        model.addAttribute("accounts", accounts);
        return "pages/dashboard/accounts";
    }

    @GetMapping("/{id}")
    public String account(@PathVariable String id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);

        return "pages/dashboard/account";
    }

    @GetMapping("/{id}/withdraw")
    public String withdrawForm(@PathVariable String id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);

        return "pages/dashboard/withdraw";
    }

    @GetMapping("/{id}/deposit")
    public String depositForm(@PathVariable String id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);

        return "pages/dashboard/deposit";
    }

    @PostMapping("/{id}/deposit")
    public String validateDeposit(@PathVariable String id, @ModelAttribute(name = "operation") Operation operation) {
        System.out.print(operation);
        accountService.CashIn(id, operation.getValue());
        return String.format("redirect:/accounts/%s", id);
    }

    @PostMapping("/{id}/transaction")
    public String validateTransaction(@PathVariable String id,
            @ModelAttribute(name = "operation") TransactionRequestDto operation) {
        System.out.print(operation);
        accountService.send(id, operation.recipientId(), operation.value());
        return String.format("redirect:/accounts/%s", id);
    }

    @PostMapping("/{id}/withdraw")
    public String validatewithdraw(@PathVariable String id,
            @ModelAttribute(name = "operation") Operation operation) {
        accountService.cashOut(id, operation.getValue());
        return String.format("redirect:/accounts/%s", id);
    }

    @GetMapping("/{id}/transaction")
    public String transactionForm(@PathVariable String id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);

        return "pages/dashboard/transaction";
    }

}
