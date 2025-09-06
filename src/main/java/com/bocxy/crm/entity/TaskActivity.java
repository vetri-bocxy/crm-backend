package com.bocxy.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "task_activity")
@Data
public class TaskActivity extends AbstractEntity{

    private String brandName;
    private LocalDate date;
    private LocalTime time;
    private String leadStatus;
    private String comments;
    private String createdUser;
    private String assignedTo;
    private String doneBy;

    @ManyToOne
    @JoinColumn(name = "contact_card_id") // Optional: explicitly set column name
    private ContactCard contactCard;
}
