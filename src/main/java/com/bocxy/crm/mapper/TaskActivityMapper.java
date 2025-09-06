package com.bocxy.crm.mapper;

import com.bocxy.crm.dto.TaskActivityDto;
import com.bocxy.crm.entity.TaskActivity;
import org.springframework.stereotype.Component;

@Component
public class TaskActivityMapper {
    public TaskActivityDto toDto(TaskActivity entity){
        TaskActivityDto dto=new TaskActivityDto();
        dto.setId(entity.getId());
        dto.setBrandName(entity.getBrandName());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setLeadStatus(entity.getLeadStatus());
        dto.setComments(entity.getComments());
        dto.setCreatedUser(entity.getCreatedUser());
        dto.setAssignedTo(entity.getAssignedTo());
        dto.setDoneBy(entity.getDoneBy());
        dto.setContactCardId(entity.getContactCard().getId());
        return dto;
    }
}
