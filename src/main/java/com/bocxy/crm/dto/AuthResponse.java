package com.bocxy.crm.dto;

import com.bocxy.crm.entity.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String role;
    private User user;

    public AuthResponse(String token, String role,User user1) {
        this.token = token;
        this.role = role;
        this.user=user1;
    }

    // Getters and Setters
}
