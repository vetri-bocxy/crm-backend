package com.bocxy.crm.repository;

import com.bocxy.crm.entity.TaskActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface TaskActivityRepository extends JpaRepository<TaskActivity, UUID> {


    @Modifying
    @Transactional
    @Query(value = """
            UPDATE task_activity 
            SET brand_name = :brandName 
            WHERE contact_card_id = :contactCardId
            """, nativeQuery = true)
    int updateBrandName(String brandName, UUID contactCardId);
}
