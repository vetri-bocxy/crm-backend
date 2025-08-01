package com.bocxy.crm.mapper;

import com.bocxy.crm.createDTO.TaskCreateDTO;
import com.bocxy.crm.dto.TaskDTO;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.updateDTO.TaskUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskCreateDTO dto) {
        Task entity=new Task();

        entity.setBrandName(dto.getBrandName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setAction(dto.getAction());
        entity.setComments(dto.getComments());
        entity.setNextAppointmentDate(dto.getNextAppointmentDate());
        entity.setNextAppointmentTime(dto.getNextAppointmentTime());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setTaskStatus(dto.getTaskStatus());
        return entity;
    }
    public Task toEntity(TaskUpdateDTO dto) {
        Task entity=new Task();
        entity.setId(dto.getId());
        entity.setBrandName(dto.getBrandName());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setAppointmentTime(dto.getAppointmentTime());
        entity.setAction(dto.getAction());
        entity.setComments(dto.getComments());
        entity.setNextAppointmentDate(dto.getNextAppointmentDate());
        entity.setNextAppointmentTime(dto.getNextAppointmentTime());
        entity.setLeadStatus(dto.getLeadStatus());
        entity.setTaskStatus(dto.getTaskStatus());
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
        return dto;
    }

}
