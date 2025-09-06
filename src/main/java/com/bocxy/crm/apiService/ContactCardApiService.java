package com.bocxy.crm.apiService;

import com.bocxy.crm.createDTO.ContactCardCreateDto;
import com.bocxy.crm.dto.ContactCardDto;
import com.bocxy.crm.mapper.ContactCardMapper;
import com.bocxy.crm.service.ContactCardService;
import com.bocxy.crm.updateDTO.ContactCardUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContactCardApiService {
    @Autowired
    ContactCardService contactCardService;
    @Autowired
    ContactCardMapper contactCardMapper;

    public ContactCardDto create(ContactCardCreateDto createDto) {
        return contactCardMapper.toDto(contactCardService.create(contactCardMapper.toEntity(createDto)));
    }

    public List<ContactCardDto> getAll() {
        return contactCardService.getAll().stream().map(contactCardMapper::toDto).toList();
    }

    public ContactCardDto getById(UUID id) {
        return contactCardMapper.toDto(contactCardService.getById(id));
    }

    public ContactCardDto update(ContactCardUpdateDto dto) {
        return contactCardMapper.toDto(contactCardService.update(contactCardMapper.toEntity(dto)));
    }

    public List<String> getAllIdentityName() {
        return contactCardService.getAllIdentityName();
    }

    public Map<String, Integer> getCountLeadStatusWise() {
        return contactCardService.getCountLeadStatusWise();
    }

    public Map<String, Map<String, Integer>> getCountLeadStatusMonthWise() {
        return contactCardService.getCountLeadStatusMonthWise();
    }
}
