package com.example.Todo.Service;

import com.example.Todo.Entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserEntity> getAllUsers();

    Optional<UserEntity> getUserById(UUID id);

    Optional<UserEntity> getUserByEmail(String email);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(UUID id, UserEntity updates);
}
