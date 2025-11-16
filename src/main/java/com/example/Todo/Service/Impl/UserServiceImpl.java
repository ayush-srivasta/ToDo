package com.example.Todo.Service.Impl;

import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Repository.UserRepository;
import com.example.Todo.Service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UUID id, UserEntity updates) {
        return userRepository.findById(id)
                .map(existing -> {
                    if (updates.getUsername() != null) existing.setUsername(updates.getUsername());
                    if (updates.getProfilePicture() != null) existing.setProfilePicture(updates.getProfilePicture());
                    existing.setUpdatedAt(Instant.now());
                    return userRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
