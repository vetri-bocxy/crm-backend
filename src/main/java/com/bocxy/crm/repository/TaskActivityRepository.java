package com.bocxy.crm.repository;

import com.bocxy.crm.entity.TaskActivity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TaskActivityRepository extends JpaRepository<TaskActivity, Id> {
    @Query(value = """
            UPDATE task_activity 
            SET brand_name=:brandName
            WHERE contact_card_id=:contactCardId
            """,nativeQuery = true)
    void updateBrandName(String brandName, UUID contactCardId);

}
