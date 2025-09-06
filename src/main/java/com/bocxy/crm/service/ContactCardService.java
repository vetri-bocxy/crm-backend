package com.bocxy.crm.service;

import com.bocxy.crm.entity.ContactCard;
import com.bocxy.crm.repository.ContactCardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactCardService {
    @Autowired
    ContactCardRepository contactCardRepository;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskActivityService taskActivityService;

    public ContactCard create(ContactCard entity) {
        ContactCard contactCard= contactCardRepository.save(entity);
        taskService.createWhileContactCard(contactCard);
        taskActivityService.createWhileContactCard(contactCard);
        return contactCard;
    }
    public ContactCard update(ContactCard entity) {
        ContactCard contactCard= contactCardRepository.save(entity);
        taskService.updateWhileContactCard(contactCard);
        taskActivityService.updateWhileContactCard(contactCard);
        return contactCard;    }


    public List<ContactCard> getAll() {
        return contactCardRepository.findAll();
    }

    public ContactCard getById(UUID id) {
        return contactCardRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Data Not Fount For This Id: "+id));
    }

    public List<String> getAllIdentityName() {
        return contactCardRepository.findAll().stream().map(ContactCard::getBrandName).toList();
    }

    public Map<String, Integer> getCountLeadStatusWise() {
        Map<String,Integer> data=new LinkedHashMap<>();

        List<Object[]> results=contactCardRepository.getContactCardCounts();
        for(Object[] row:results){
            String key=row[0].toString();
            int value=((Number) row[1]).intValue();

            switch (key){
                case "Follow Up" -> data.put("followUp",value);
                case "In-line" -> data.put("inLine",value);
                case "Prospect"-> data.put("prospect",value);
                case "Converted"-> data.put("converted",value);
                case "Not Interested"-> data.put("notInterested",value);
                case "overAllContactCard"-> data.put("overAllContactCard",value);
                default -> data.put(key,value);
            }
        }
//        data.put("overallContactCard",contactCardRepository.findAllContactCardCount());
//        data.put("followUp",contactCardRepository.findContactCardByLeadStatus("Follow Up"));
//        data.put("inLine",contactCardRepository.findContactCardByLeadStatus("In-line"));
//        data.put("prospect",contactCardRepository.findContactCardByLeadStatus("Prospect"));
//        data.put("converted",contactCardRepository.findContactCardByLeadStatus("Converted"));
//        data.put("notInterested",contactCardRepository.findContactCardByLeadStatus("Not Interested"));
        return data;
    }

    public Map<String, Map<String, Integer>> getCountLeadStatusMonthWise() {
        Map<String, Map<String, Integer>> data = new LinkedHashMap<>();

        List<Object[]> results = contactCardRepository.getCountLeadStatusMonthWise();
        for (Object[] row : results) {
            String month = row[0].toString();          // e.g., "2025-01"
            String status = row[1].toString();         // e.g., "Follow Up"
            int count = ((Number) row[2]).intValue();  // e.g., 10

            data.putIfAbsent(month, new LinkedHashMap<>());

            switch (status) {
                case "Follow Up" -> data.get(month).put("followUp", count);
                case "In-line"   -> data.get(month).put("inLine", count);
                case "Prospect"  -> data.get(month).put("prospect", count);
                case "Converted" -> data.get(month).put("converted", count);
                case "Not Interested" -> data.get(month).put("notInterested", count);
                default -> data.get(month).put(status, count);
            }
        }

        return data;
    }

}
