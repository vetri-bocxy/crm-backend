package com.bocxy.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(generator = "UUID_Task")
    @GenericGenerator(name = "UUID_Task", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "id",nullable = false,updatable = false,length = 36)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String brandName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String action;
    private String comments;
    private LocalDate nextAppointmentDate;
    private LocalTime nextAppointmentTime;
    private String leadStatus;
    private String taskStatus;

    @ManyToOne
    @JoinColumn(name = "contact_card_id")
    private ContactCard contactCard;

}
