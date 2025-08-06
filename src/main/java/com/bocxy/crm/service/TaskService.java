package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Task update(Task toDTO) {
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

    public Task updateWhileContactCard(ContactCard card){
        Task task=repository.findByContactCardId(card.getId())
                .orElseThrow(()-> new EntityNotFoundException("Data Not Fount For This Id: "+ card.getId()));

        task.setBrandName(card.getBrandName());
        task.setAppointmentDate(card.getAppointmentStartDate());
        task.setAppointmentTime(card.getAppointmentTime());
        task.setAction(card.getAction());
        task.setLeadStatus(card.getLeadStatus());
        task.setContactCard(card);

        return repository.save(task);
    }

    public List<Task> getAll() {
        return repository.findAll();

    }

    public Task getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    public Task updateFollowUp(Task entity) {
        //new followup task
        Task newTask=new Task();
        newTask.setBrandName(entity.getBrandName());
        newTask.setAppointmentDate(entity.getNextAppointmentDate());
        newTask.setAppointmentTime(entity.getNextAppointmentTime());
        newTask.setAction(entity.getAction());
        newTask.setLeadStatus(entity.getLeadStatus());
        newTask.setContactCard(entity.getContactCard());
        Task newEntity=repository.save(newTask);

        //close previous task
        entity.setTaskStatus("close");
        repository.save(entity);
        return newEntity;
    }
}
