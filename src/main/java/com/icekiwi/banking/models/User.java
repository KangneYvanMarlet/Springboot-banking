package com.icekiwi.banking.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String matricule;
    private String username;
    private String email;
    private String Phone;

    private Boolean locked = false;
    private String Password;

    @CreationTimestamp
    private Date creationDate;
    // get account authorities

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("user"));
    }

    // check if account is non expired
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // check if account is non locked
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    // check if credential is non expired
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // check if account is enabled
    @Override
    public boolean isEnabled() {
        return true;
    }
}
