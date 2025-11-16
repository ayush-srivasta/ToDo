package com.example.Todo.Repository;

import com.example.Todo.Entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ListRepository extends JpaRepository<ListEntity, UUID> {
    List<ListEntity> findByUser_UserId(UUID userId);
    List<ListEntity> findByGroup_GroupId(UUID groupId);
}
