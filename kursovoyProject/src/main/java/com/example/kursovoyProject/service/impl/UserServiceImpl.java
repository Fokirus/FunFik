package com.example.kursovoyProject.service.impl;

import com.example.kursovoyProject.entity.User;
import com.example.kursovoyProject.repository.UserRepository;
import com.example.kursovoyProject.service.UserService;
import com.example.kursovoyProject.utils.HashUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void registration(String username, String email, String password){
        Optional<User> userWithUsernameOptional = userRepository.findOneByUsername(username);
        Optional<User> userWithEmailOptional = userRepository.findOneByEmail(email);

        if(userWithUsernameOptional.isPresent()){
            throw new RuntimeException("User with such username exists.");
        }

        if(userWithEmailOptional.isPresent()){
            throw new RuntimeException("User with such email exists.");
        }

        String hashPassword = HashUtils.compute(password);
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashPassword);
        userRepository.save(user);
    }

    @Override
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
