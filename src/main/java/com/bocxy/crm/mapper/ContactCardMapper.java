package com.bocxy.crm.mapper;

import com.bocxy.crm.createDTO.ContactCardCreateDto;
import com.bocxy.crm.dto.ContactCardDto;
import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.updateDTO.ContactCardUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactCardMapper {
    @Autowired
    TaskMapper taskMapper;

    public ContactCard toEntity(ContactCardCreateDto dto) {
        ContactCard entity=new ContactCard();
        entity.setBrandName(dto.getBrandName());
        entity.setOwnerName(dto.getOwnerName());
        entity.setSpeciality(dto.getSpeciality());
        entity.setBusinessType(dto.getBusinessType());
        entity.setPointOfContact(dto.getPointOfContact());
        entity.setPrimaryContactNumber(dto.getPrimaryContactNumber());
        entity.setSecondaryContactNumber(dto.getSecondaryContactNumber());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setAppointmentStartDate(dto.getAppointmentStartDate());
        entity.setAppointmentEndDate(dto.getAppointmentEndDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setReferralSource(dto.getReferralSource());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setPinCode(dto.getPinCode());
        entity.setFileUpload(dto.getFileUpload());
        entity.setCreatedUser(dto.getCreatedUser());
        entity.setAssignedTo(dto.getAssignedTo());
        entity.setAction(dto.getAction());

        return entity;
    }

    public ContactCard toEntity(ContactCardUpdateDto dto) {
        ContactCard entity=new ContactCard();
        entity.setId(dto.getId());
        entity.setBrandName(dto.getBrandName());
        entity.setOwnerName(dto.getOwnerName());
        entity.setSpeciality(dto.getSpeciality());
        entity.setBusinessType(dto.getBusinessType());
        entity.setPointOfContact(dto.getPointOfContact());
        entity.setPrimaryContactNumber(dto.getPrimaryContactNumber());
        entity.setSecondaryContactNumber(dto.getSecondaryContactNumber());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setAppointmentStartDate(dto.getAppointmentStartDate());
        entity.setAppointmentEndDate(dto.getAppointmentEndDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setReferralSource(dto.getReferralSource());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setPinCode(dto.getPinCode());
        entity.setFileUpload(dto.getFileUpload());
        entity.setCreatedUser(dto.getCreatedUser());
        entity.setAssignedTo(dto.getAssignedTo());
        entity.setAction(dto.getAction());
        return entity;
    }

    public ContactCardDto toDto(ContactCard entity) {
        ContactCardDto dto=new ContactCardDto();
        dto.setId(entity.getId());
        dto.setBrandName(entity.getBrandName());
        dto.setOwnerName(entity.getOwnerName());
        dto.setSpeciality(entity.getSpeciality());
        dto.setBusinessType(entity.getBusinessType());
        dto.setPointOfContact(entity.getPointOfContact());
        dto.setPrimaryContactNumber(entity.getPrimaryContactNumber());
        dto.setSecondaryContactNumber(entity.getSecondaryContactNumber());
        dto.setLeadStatus(entity.getLeadStatus());
        dto.setAppointmentStartDate(entity.getAppointmentStartDate());
        dto.setAppointmentEndDate(entity.getAppointmentEndDate());
        dto.setAppointmentTime(entity.getAppointmentTime());
        dto.setReferralSource(entity.getReferralSource());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setPinCode(entity.getPinCode());
        dto.setFileUpload(entity.getFileUpload());
        dto.setCreatedUser(entity.getCreatedUser());
        dto.setAssignedTo(entity.getAssignedTo());
        dto.setAction(entity.getAction());
        return dto;
    }
}
