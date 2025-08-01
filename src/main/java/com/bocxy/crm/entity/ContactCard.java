package com.bocxy.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contact_cards")
@Data
public class ContactCard {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String brandName;//identity name
    private String ownerName;//primary name
    private String speciality;
    private String businessType;
    private String pointOfContact;//primary contact person

    private String primaryContactNumber;

    private String secondaryContactNumber;

    private String leadStatus;

    private LocalDate appointmentStartDate;

    private LocalDate appointmentEndDate;

    private LocalTime appointmentTime;

    private String referralSource;

    @Email
    private String email;
    private String address;
    private String city;
    private String pinCode;
    private String fileUpload;
    private String createdUser;

    @OneToMany(mappedBy = "contactCard", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Task> taskList = new ArrayList<>();



}
