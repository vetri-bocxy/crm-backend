package com.bocxy.crm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ContactCardDto {
    private UUID id;
    private String clinicName;
    private String doctorName;
    private String ownerName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;

    private String referenceFrom;
    private String businessType;
    private String mobileNo;
    private String email;
    private String fileUpload;
}
