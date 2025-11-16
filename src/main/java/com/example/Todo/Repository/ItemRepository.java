package com.example.Todo.Repository;

import com.example.Todo.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    List<ItemEntity> findByList_ListId(UUID listId);
}
