package com.example.thymeleaftest.repository;

import com.example.thymeleaftest.model.Board;
import com.example.thymeleaftest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
