package com.staging.staging_juwangi.dto;

import com.staging.staging_juwangi.model.Users;

public class UserProfileDTO {
    private String username;
    private String email;

    public UserProfileDTO(Users user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
