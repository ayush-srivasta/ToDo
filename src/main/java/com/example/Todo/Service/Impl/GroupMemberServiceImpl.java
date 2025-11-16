package com.example.Todo.Service.Impl;

import com.example.Todo.Entity.GroupMemberEntity;
import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Entity.UserGroupEntity;
import com.example.Todo.Repository.*;
import com.example.Todo.Service.GroupMemberService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;
    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;

    public GroupMemberServiceImpl(GroupMemberRepository groupMemberRepository,
                                  UserGroupRepository userGroupRepository,
                                  UserRepository userRepository) {
        this.groupMemberRepository = groupMemberRepository;
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<UserEntity> getMembersByGroup(UUID groupId) {
        List<GroupMemberEntity> members = groupMemberRepository.findByGroup_GroupId(groupId);
        return members.stream().map(GroupMemberEntity::getUser).collect(Collectors.toList());
    }

    @Override
    public GroupMemberEntity addMember(UUID groupId, UUID userId, String role) {
        UserGroupEntity group = userGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        groupMemberRepository.findByGroup_GroupIdAndUser_UserId(groupId, userId)
                .ifPresent(m -> { throw new RuntimeException("User already a member"); });
        GroupMemberEntity member = new GroupMemberEntity();
        member.setGroup(group);
        member.setUser(user);
        member.setRole(role == null ? "member" : role);
        return groupMemberRepository.save(member);
    }

    @Override
    public void removeMember(UUID groupId, UUID userId) {
        groupMemberRepository.deleteByGroup_GroupIdAndUser_UserId(groupId, userId);
    }



}