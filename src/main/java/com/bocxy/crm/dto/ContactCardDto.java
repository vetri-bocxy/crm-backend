package com.bocxy.crm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
public class ContactCardDto {//response dto
    private UUID id;
    private String brandName;//identity name
    private String ownerName;//primary name
    private String speciality;
    private String businessType;
    private String pointOfContact;//primary contact

    private String primaryContactNumber;//primary contact number

    private String secondaryContactNumber;//secondary contact number

    private String leadStatus;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentStartDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentEndDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;



    private String referralSource;

    @Email
    private String email;
    private String address;
    private String city;
    private String pinCode;
    private String fileUpload;
    private String createdUser;

    private List<TaskDTO> taskDTOList;
}
