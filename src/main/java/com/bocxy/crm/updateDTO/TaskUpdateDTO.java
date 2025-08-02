package com.bocxy.crm.updateDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Data
public class TaskUpdateDTO {

    private UUID id;
    private String brandName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    private LocalTime appointmentTime;
    private String action;
    private String comments;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nextAppointmentDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    private LocalTime nextAppointmentTime;
    private String leadStatus;
    private String taskStatus;
}

