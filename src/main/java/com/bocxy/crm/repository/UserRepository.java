package com.bocxy.crm.repository;

import com.bocxy.crm.entity.Role;
import com.bocxy.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);

}

