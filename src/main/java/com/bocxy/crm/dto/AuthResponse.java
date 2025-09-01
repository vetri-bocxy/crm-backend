package com.bocxy.crm.dto;

import com.bocxy.crm.entity.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private User user;

    public AuthResponse(String token,User user1) {
        this.token = token;
        this.user=user1;
    }

    // Getters and Setters
}
