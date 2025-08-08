package com.bocxy.crm.repository;

import com.bocxy.crm.entity.TaskActivity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskActivityRepository extends JpaRepository<TaskActivity, Id> {

}
