package com.bocxy.crm.updateDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ContactCardUpdateDto {
    @NotNull
    private UUID id;

    private String clinicName;
    private String doctorName;
    private String ownerName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;

    private String referenceFrom;
    private String businessType;
    private String mobileNo;
    private String email;
    private String fileUpload;
}
