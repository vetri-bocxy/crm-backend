package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.entity.TaskActivity;
import com.bocxy.crm.repository.TaskActivityRepository;
import com.bocxy.crm.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    TaskRepository repository;
    @Autowired
    TaskActivityService activityService;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task toDTO) {
        return repository.save(toDTO);
    }

    public Task update(Task toDTO) {
        return repository.save(toDTO);
    }

    public void createWhileContactCard(ContactCard card){
        Task entity=new Task();

        entity.setBrandName(card.getBrandName());
        entity.setAppointmentDate(card.getAppointmentEndDate());
        entity.setAppointmentTime(card.getAppointmentTime());
        entity.setAction(card.getAction());
        entity.setLeadStatus(card.getLeadStatus());
        entity.setTaskStatus("open");
        entity.setContactCard(card);

        repository.save(entity);
    }

    public void updateWhileContactCard(ContactCard card){
        Task task=repository.findByContactCardIdAndTaskStatus(card.getId(),"open")
                .orElseThrow(()-> new EntityNotFoundException("Data Not Fount For This Id: "+ card.getId()));

        task.setBrandName(card.getBrandName());
        task.setContactCard(card);
        task.setAppointmentDate(card.getAppointmentEndDate());
        task.setAppointmentTime(card.getAppointmentTime());

        repository.save(task);
    }

    public List<Task> getAll() {
        return repository.findAll();

    }

    public Task getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    public Task updateFollowUp(Task entity) {
        //create new followup task
        Task newTask=new Task();
        newTask.setBrandName(entity.getBrandName());
        newTask.setAppointmentDate(entity.getNextAppointmentDate());
        newTask.setAppointmentTime(entity.getNextAppointmentTime());
        newTask.setAction(entity.getAction());
        newTask.setLeadStatus(entity.getLeadStatus());
        newTask.setTaskStatus("open");
        newTask.setContactCard(entity.getContactCard());
        Task newEntity=repository.save(newTask);

        //create new Task-activity
        activityService.createWhileTask(entity);

        //close previous task
        entity.setTaskStatus("close");
        repository.save(entity);


        return newEntity;
    }
}
