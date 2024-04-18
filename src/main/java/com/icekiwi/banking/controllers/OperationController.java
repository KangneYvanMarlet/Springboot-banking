package com.icekiwi.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icekiwi.banking.models.Operation;
import com.icekiwi.banking.services.OperationService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/operations")
@AllArgsConstructor
public class OperationController {

    @Autowired
    private final OperationService operationService;

    @GetMapping
    public String operations(Model model) {
        List<Operation> operations = operationService.getOperations();
        model.addAttribute("operations", operations);
        return "pages/dashboard/operations";
    }

    @PostMapping
    public String createOperation(@PathVariable String id) {
        return "redirect : /operations";
    }

}
