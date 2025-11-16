package com.example.Todo.Service;

import com.example.Todo.Entity.UserGroupEntity;

import java.util.List;
import java.util.UUID;

public interface UserGroupService {

    UserGroupEntity createGroup(UUID createdBy, String groupName, String description);
    List<UserGroupEntity> getGroupsByUser(UUID userId);
    UserGroupEntity getGroupById(UUID groupId);
    void deleteGroup(UUID groupId);
}
