package com.bocxy.crm.apiService;

import com.bocxy.crm.dto.TaskActivityDto;
import com.bocxy.crm.mapper.TaskActivityMapper;
import com.bocxy.crm.service.TaskActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskActivityApiService {
    @Autowired
    TaskActivityService taskActivityService;
    @Autowired
    TaskActivityMapper taskActivityMapper;

    public List<TaskActivityDto> getAll() {
        return taskActivityService.getAll().stream().map(taskActivityMapper::toDto).toList();
    }
}
