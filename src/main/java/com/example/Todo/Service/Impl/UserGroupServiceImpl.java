package com.example.Todo.Service.Impl;


import com.example.Todo.Entity.GroupMemberEntity;
import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Entity.UserGroupEntity;
import com.example.Todo.Repository.GroupMemberRepository;
import com.example.Todo.Repository.UserGroupRepository;
import com.example.Todo.Repository.UserRepository;
import com.example.Todo.Service.UserGroupService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;
    private final GroupMemberRepository groupMemberRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository, UserRepository userRepository, GroupMemberRepository groupMemberRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
        this.groupMemberRepository = groupMemberRepository;
    }
    @Override
    public UserGroupEntity createGroup(UUID createdBy, String groupName, String description) {
        UserEntity creator = userRepository.findById(createdBy)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserGroupEntity group = new UserGroupEntity();
        group.setGroupName(groupName);
        group.setDescription(description);
        group.setCreatedBy(creator);
        UserGroupEntity savedGroup = userGroupRepository.save(group);

        GroupMemberEntity ownerMember = new GroupMemberEntity();
        ownerMember.setGroup(savedGroup);
        ownerMember.setUser(creator);
        ownerMember.setRole("owner");
        groupMemberRepository.save(ownerMember);
        return savedGroup;
    }

    @Override
    public List<UserGroupEntity> getGroupsByUser(UUID userId) {
        return userGroupRepository.findByCreatedBy_UserId(userId);
    }

    @Override
    public UserGroupEntity getGroupById(UUID groupId) {
        return userGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public void deleteGroup(UUID groupId) {
        userGroupRepository.deleteById(groupId);
    }
}
