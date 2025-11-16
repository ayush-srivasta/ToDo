package com.example.Todo.Repository;

import com.example.Todo.Entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, UUID> {
    List<UserGroupEntity> findByCreatedBy_UserId(UUID userId);
}
