package com.example.kursovoyProject.service;

import com.example.kursovoyProject.entity.User;

import java.util.List;

public interface UserService {
    public void registration(String username, String email, String password);
    public User creatUser(User user);
    public User findUserById(Long id);
    public User updateUser(User user);
    public void deleteUser(Long id);
    public List<User> findAllUsers();
}
