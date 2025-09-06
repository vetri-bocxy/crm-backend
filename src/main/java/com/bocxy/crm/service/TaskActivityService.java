package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.entity.Task;
import com.bocxy.crm.entity.TaskActivity;
import com.bocxy.crm.repository.TaskActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TaskActivityService {
    @Autowired
    TaskActivityRepository repo;
    public void createWhileContactCard(ContactCard contactCard) {
        TaskActivity entity=new TaskActivity();
        entity.setBrandName(contactCard.getBrandName());
        entity.setDate(LocalDate.now());
        entity.setTime(LocalTime.now());
        entity.setLeadStatus(contactCard.getLeadStatus());
        entity.setComments("Contact Created");
        entity.setContactCard(contactCard);
        entity.setCreatedUser(contactCard.getCreatedUser());
        entity.setAssignedTo(contactCard.getAssignedTo());
        entity.setDoneBy(contactCard.getCreatedUser());
        repo.save(entity);
    }

    public void createWhileTask(Task task) {
        TaskActivity newEntity=new TaskActivity();
        newEntity.setBrandName(task.getBrandName());
        newEntity.setDate(LocalDate.now());
        newEntity.setTime(LocalTime.now());
        newEntity.setLeadStatus(task.getLeadStatus());
        newEntity.setComments(task.getComments());
        newEntity.setCreatedUser(task.getCreatedUser());
        newEntity.setAssignedTo(task.getAssignedTo());
        newEntity.setDoneBy(task.getDoneBy());
        newEntity.setContactCard(task.getContactCard());
        repo.save(newEntity);
    }


    public List<TaskActivity> getAll() {
        return repo.findAll();
    }

    public void updateWhileContactCard(ContactCard contactCard) {
        repo.updateBrandName(contactCard.getBrandName(),contactCard.getId());
    }
}
