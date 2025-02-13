package com.staging.staging_juwangi.dto;

import com.staging.staging_juwangi.model.User;

public class UserProfileDTO {
    private String username;
    private String email;

    public UserProfileDTO(User user) {
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
