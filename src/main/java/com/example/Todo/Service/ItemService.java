package com.example.Todo.Service;

import com.example.Todo.Entity.ItemEntity;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    ItemEntity addItem(UUID listId, UUID createdBy, String title, String attributes, int priority);
    List<ItemEntity> getItemsForList(UUID listId);
    ItemEntity updateItem(UUID itemId, String title, Boolean isCompleted, String attributes, Integer priority);
    void deleteItem(UUID itemId);
}
