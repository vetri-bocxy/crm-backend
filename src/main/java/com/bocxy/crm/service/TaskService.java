package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
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

    public Task createWhileContactCard(ContactCard card){
        Task entity=new Task();

        entity.setBrandName(card.getBrandName());
        entity.setAppointmentDate(card.getAppointmentStartDate());
        entity.setAppointmentTime(card.getAppointmentTime());
        entity.setAction(card.getAction());
        entity.setLeadStatus(card.getLeadStatus());
        entity.setContactCard(card);

        return repository.save(entity);
    }

    public List<Task> getAll() {
        return repository.findAll();

    }

    public Task getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
