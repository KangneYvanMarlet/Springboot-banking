package com.icekiwi.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icekiwi.banking.converters.UserConverter;
import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.models.User;
import com.icekiwi.banking.services.AccountService;
import com.icekiwi.banking.services.OperationService;
import com.icekiwi.banking.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DashboardController {

    @Autowired
    private final OperationService operationService;

    @Autowired
    private final AccountService AccountService;

    private final UserService userService;

    private final UserConverter userConverter;

    @GetMapping
    public String home(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Operation> operations = operationService.getOperations();
        model.addAttribute("user", userConverter.convertUserToUserDto(user));
        model.addAttribute("operations", operations);

        return "pages/dashboard/index";
    }

}
