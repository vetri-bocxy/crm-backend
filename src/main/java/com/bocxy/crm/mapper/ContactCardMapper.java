package com.bocxy.crm.mapper;

import com.bocxy.crm.createDTO.ContactCardCreateDto;
import com.bocxy.crm.dto.ContactCardDto;
import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.updateDTO.ContactCardUpdateDto;
import org.springframework.stereotype.Component;

@Component
public class ContactCardMapper {
    public ContactCard toEntity(ContactCardCreateDto dto) {
        ContactCard entity=new ContactCard();
        entity.setClinicName(dto.getClinicName());
        entity.setDoctorName(dto.getDoctorName());
        entity.setOwnerName(dto.getOwnerName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setReferenceFrom(dto.getReferenceFrom());
        entity.setBusinessType(dto.getBusinessType());
        entity.setMobileNo(dto.getMobileNo());
        entity.setEmail(dto.getEmail());
        entity.setFileUpload(dto.getFileUpload());
        return entity;
    }

    public ContactCard toEntity(ContactCardUpdateDto dto) {
        ContactCard entity=new ContactCard();
        entity.setId(dto.getId());
        entity.setClinicName(dto.getClinicName());
        entity.setDoctorName(dto.getDoctorName());
        entity.setOwnerName(dto.getOwnerName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setReferenceFrom(dto.getReferenceFrom());
        entity.setBusinessType(dto.getBusinessType());
        entity.setMobileNo(dto.getMobileNo());
        entity.setEmail(dto.getEmail());
        entity.setFileUpload(dto.getFileUpload());
        return entity;
    }

    public ContactCardDto toDto(ContactCard entity) {
        ContactCardDto dto=new ContactCardDto();
        dto.setId(entity.getId());
        dto.setClinicName(entity.getClinicName());
        dto.setDoctorName(entity.getDoctorName());
        dto.setOwnerName(entity.getOwnerName());
        dto.setAppointmentDate(entity.getAppointmentDate());
        dto.setAppointmentTime(entity.getAppointmentTime());
        dto.setReferenceFrom(entity.getReferenceFrom());
        dto.setBusinessType(entity.getBusinessType());
        dto.setMobileNo(entity.getMobileNo());
        dto.setEmail(entity.getEmail());
        dto.setFileUpload(entity.getFileUpload());

        return dto;
    }
}
