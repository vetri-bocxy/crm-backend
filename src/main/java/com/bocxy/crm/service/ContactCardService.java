package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.repository.ContactCardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactCardService {
    @Autowired
    ContactCardRepository contactCardRepository;
    @Autowired
    TaskService taskService;

    public ContactCard createOrUpdate(ContactCard entity) {
        ContactCard contactCard= contactCardRepository.save(entity);
        taskService.createWhileContactCard(contactCard);
        return contactCard;
    }

    public List<ContactCard> getAll() {
        return contactCardRepository.findAll();
    }

    public ContactCard getById(UUID id) {
        return contactCardRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Data Not Fount For This Id: "+id));
    }
}
