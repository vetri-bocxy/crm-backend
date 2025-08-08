package com.bocxy.crm.updateDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class TaskActivityUpdateDto {
    private UUID id;
    private String brandName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;
    private String leadStatus;
    private String comments;
    private UUID contactCardId;
}
