package com.bocxy.crm.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "id", updatable = false, nullable = false, unique = true,length = 36)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String designation;
    private String profilePicPath;

    @Enumerated(EnumType.STRING)
    private Role role;



}
