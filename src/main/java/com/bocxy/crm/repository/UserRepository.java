package com.bocxy.crm.repository;

import com.bocxy.crm.entity.Role;
import com.bocxy.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT u.username FROM users u",nativeQuery = true)
    List<String> findUsernames();
}

