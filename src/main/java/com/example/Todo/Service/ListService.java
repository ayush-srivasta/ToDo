package com.example.Todo.Service;

import com.example.Todo.Entity.ListEntity;

import java.util.List;
import java.util.UUID;

public interface ListService {
    ListEntity createList(UUID createdBy, UUID userId, UUID groupId, String title, String description, String listType);
    List<ListEntity> getListsForUser(UUID userId);
    List<ListEntity> getListsForGroup(UUID groupId);
    ListEntity getList(UUID listId);
    ListEntity updateList(UUID listId, String title, String description);
    void deleteList(UUID listId);
}
