package com.bocxy.crm.createDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ContactCardCreateDto {
    @NotBlank
    private String clinicName;

    private String doctorName;

    private String ownerName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;

    private String referenceFrom;

    private String businessType;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @Email
    private String email;

    private String fileUpload;
}
