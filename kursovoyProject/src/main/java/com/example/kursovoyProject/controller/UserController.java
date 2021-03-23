package com.example.kursovoyProject.controller;

import com.example.kursovoyProject.dto.RegistrationDto;
import com.example.kursovoyProject.entity.User;
import com.example.kursovoyProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody RegistrationDto dto){
        userService.registration(dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    @PostMapping
    public User creatUser(User user) {
        return userService.creatUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);

        return userService.findUserById(id);
    }

    @PutMapping
    public User updateUsers(User user){
        return userService.updateUser(user);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
