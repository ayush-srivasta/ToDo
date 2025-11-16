package com.example.Todo.Controller;

import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }


    @PatchMapping("/{id}")
    public UserEntity updateUser(@PathVariable UUID id, @RequestBody UserEntity updates) {
        return userService.updateUser(id, updates);
    }
}
