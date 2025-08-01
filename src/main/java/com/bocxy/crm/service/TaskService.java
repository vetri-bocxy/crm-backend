package com.bocxy.crm.service;

import com.bocxy.crm.entity.Task;
import com.bocxy.crm.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task toDTO) {
        return repository.save(toDTO);
    }

    public List<Task> getAll() {
        return repository.findAll();

    }

    public Task getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
