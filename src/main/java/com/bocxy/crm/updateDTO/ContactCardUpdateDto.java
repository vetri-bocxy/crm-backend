package com.bocxy.crm.updateDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ContactCardUpdateDto {
    @NotNull
    private UUID id;

    private String brandName;//identity name
    private String ownerName;//primary name
    private String speciality;
    private String businessType;
    private String pointOfContact;//primary contact

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String primaryContactNumber;//primary contact number

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
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

//    @JsonFormat(pattern = "dd-MM-yyyy")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    private LocalDate appointmentDate;
//
//    @JsonFormat(pattern = "HH:mm")
//    @DateTimeFormat(pattern = "HH:mm")
//    private LocalTime appointmentTime;
}
