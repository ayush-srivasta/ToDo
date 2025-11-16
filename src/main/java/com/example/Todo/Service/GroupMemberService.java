package com.example.Todo.Service;

import com.example.Todo.Entity.GroupMemberEntity;
import com.example.Todo.Entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface GroupMemberService {


    List<UserEntity> getMembersByGroup(UUID groupId);
    GroupMemberEntity addMember(UUID groupId, UUID userId, String role);
    void removeMember(UUID groupId, UUID userId);

}
