package com.bocxy.crm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class TaskActivityDto {
    private UUID id;
    private String brandName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;
    private String leadStatus;
    private String comments;
    private String createdUser;
    private String assignedTo;
    private String doneBy;
    private UUID contactCardId;
}
