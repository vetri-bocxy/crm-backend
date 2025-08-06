package com.bocxy.crm.apiService;

import com.bocxy.crm.createDTO.TaskCreateDTO;
import com.bocxy.crm.dto.TaskDTO;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.mapper.TaskMapper;
import com.bocxy.crm.service.TaskService;
import com.bocxy.crm.updateDTO.TaskUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskApiService {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskApiService(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    public TaskDTO create(TaskCreateDTO createDto) {
       return taskMapper.toDto(taskService.create(taskMapper.toEntity(createDto)));
    }

    public List<TaskDTO> getAll() {
      List<Task>  data= taskService.getAll();
     return data.stream().map(taskMapper::toDto).toList();
    }

    public TaskDTO getById(UUID id) {
        return taskMapper.toDto(taskService.getById(id));

    }

    public TaskDTO update(TaskUpdateDTO dto) {
        return taskMapper.toDto(taskService.update(taskMapper.toEntity(dto)));

    }

    public TaskDTO updateFollowUp(TaskUpdateDTO dto) {
        return taskMapper.toDto(taskService.updateFollowUp(taskMapper.toEntity(dto)));
    }
}
