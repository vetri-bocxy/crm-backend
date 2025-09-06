package com.bocxy.crm.repository;

import com.bocxy.crm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<Task> findByContactCardId(UUID id);

    Optional<Task> findByContactCardIdAndTaskStatus(UUID id, String open);

    @Query(value = """
            UPDATE tasks 
            SET brand_name=:brandName 
            WHERE contact_card_id=:contactCardId
            """,nativeQuery = true)
    void updateBrandName(String brandName, UUID contactCardId);

}
