package com.bocxy.crm.mapper;

import com.bocxy.crm.createDTO.ContactCardCreateDto;
import com.bocxy.crm.createDTO.TaskCreateDTO;
import com.bocxy.crm.dto.TaskDTO;
import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.repository.ContactCardRepository;
import com.bocxy.crm.updateDTO.TaskUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    @Autowired
    ContactCardRepository repo;
    public Task toEntity(TaskCreateDTO dto) {

        ContactCard contactCard=repo.findById(dto.getContactCardId())
                .orElseThrow(()->new EntityNotFoundException("Contact card not there for the id"));
        Task entity=new Task();

        entity.setBrandName(dto.getBrandName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setAction(dto.getAction());
        entity.setComments(dto.getComments());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setTaskStatus(dto.getTaskStatus());
        entity.setContactCard(contactCard);
        return entity;
    }
    public Task toEntity(TaskUpdateDTO dto) {
        ContactCard contactCard=repo.findById(dto.getContactCardId())
                .orElseThrow(()->new EntityNotFoundException("Contact card not there for the id"));
        Task entity=new Task();
        entity.setId(dto.getId());
        entity.setBrandName(dto.getBrandName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setAction(dto.getAction());
        entity.setComments(dto.getComments());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setTaskStatus(dto.getTaskStatus());
        entity.setContactCard(contactCard);
        return entity;
    }

    public TaskDTO toDto(Task entity) {
        TaskDTO dto=new TaskDTO();
        dto.setId(entity.getId());
        dto.setBrandName(entity.getBrandName());
        dto.setAppointmentDate(entity.getAppointmentDate());
        dto.setAppointmentTime(entity.getAppointmentTime());
        dto.setAction(entity.getAction());
        dto.setComments(entity.getComments());
        dto.setNextAppointmentDate(entity.getNextAppointmentDate());
        dto.setNextAppointmentTime(entity.getNextAppointmentTime());
        dto.setLeadStatus(entity.getLeadStatus());
        dto.setTaskStatus(dto.getTaskStatus());
        dto.setContactCardId(entity.getContactCard().getId());
        return dto;
    }

}
