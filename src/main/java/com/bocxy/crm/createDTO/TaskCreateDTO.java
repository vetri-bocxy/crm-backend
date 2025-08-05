package com.bocxy.crm.createDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class TaskCreateDTO {
    private String brandName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;
    private String action;
    private String comments;
    private String leadStatus;
    private String taskStatus;

    private UUID contactCardId;

}


