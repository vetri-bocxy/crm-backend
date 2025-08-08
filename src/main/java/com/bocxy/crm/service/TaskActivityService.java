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
        TaskActivity newEntity=new TaskActivity();
        newEntity.setBrandName(contactCard.getBrandName());
        newEntity.setDate(LocalDate.now());
        newEntity.setTime(LocalTime.now());
        newEntity.setLeadStatus(contactCard.getLeadStatus());
        newEntity.setComments("Contact Created");
        newEntity.setContactCard(contactCard);
        repo.save(newEntity);
    }

    public void createWhileTask(Task task) {
        TaskActivity newEntity=new TaskActivity();
        newEntity.setBrandName(task.getBrandName());
        newEntity.setDate(LocalDate.now());
        newEntity.setTime(LocalTime.now());
        newEntity.setLeadStatus(task.getLeadStatus());
        newEntity.setComments(task.getComments());
        newEntity.setContactCard(task.getContactCard());
        repo.save(newEntity);
    }


    public List<TaskActivity> getAll() {
        return repo.findAll();
    }
}
