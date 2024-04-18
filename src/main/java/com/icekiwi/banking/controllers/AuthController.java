package com.icekiwi.banking.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icekiwi.banking.dto.AuthenticationDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @GetMapping("login")
    public String loginForm() {
        return "pages/auth/login";
    }

    @PostMapping("login")
    public void validateLogin(@RequestBody AuthenticationDto authenticationDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(),
                        authenticationDto.password())

        );
        if (authentication.isAuthenticated()) {
            // return this.jwtService.generate(authenticationDto.username());
        }

    }

    @GetMapping("logout")
    private void logout() {

    }

}
