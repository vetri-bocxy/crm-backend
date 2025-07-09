package com.bocxy.crm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "contact_cards")
@Data
public class ContactCard {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;

    private String clinicName;
    private String doctorName;
    private String ownerName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String referenceFrom;
    private String businessType;
    private String mobileNo;
    private String email;
    private String fileUpload;
}
