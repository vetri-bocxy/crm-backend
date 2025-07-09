package com.bocxy.crm.createDTO;

import com.bocxy.crm.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserCreateDto {
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String designation;
    private String profilePicPath;

    @Enumerated(EnumType.STRING)
    private Role role;
}
