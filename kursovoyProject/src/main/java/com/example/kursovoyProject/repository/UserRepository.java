package com.example.kursovoyProject.repository;

import com.example.kursovoyProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findOneByUsername(String username);
    public Optional<User> findOneByEmail(String email);
}
