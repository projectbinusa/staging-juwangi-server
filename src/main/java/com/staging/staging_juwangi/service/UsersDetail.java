package com.staging.staging_juwangi.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.staging.staging_juwangi.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UsersDetail implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;

    @JsonIgnore
    private String password;

    public UsersDetail(Long id, String email, String password) {
        this.id = id;
        this.username = email;
        this.password = password;
    }

    public static UsersDetail buildUser(Users admin) {
        return new UsersDetail(
                admin.getId(),
                admin.getEmail(),
                admin.getPassword());
    }


    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsersDetail admin = (UsersDetail) o;
        return Objects.equals(id, admin.id);
    }
}