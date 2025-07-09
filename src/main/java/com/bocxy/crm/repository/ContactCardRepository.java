package com.bocxy.crm.repository;

import com.bocxy.crm.entity.ContactCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactCardRepository extends JpaRepository<ContactCard, UUID> {

}
