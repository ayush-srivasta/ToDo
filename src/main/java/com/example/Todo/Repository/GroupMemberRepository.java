package com.example.Todo.Repository;

import com.example.Todo.Entity.GroupMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupMemberRepository extends JpaRepository<GroupMemberEntity, UUID> {

    List<GroupMemberEntity> findByGroup_GroupId(UUID groupId);
    Optional<GroupMemberEntity> findByGroup_GroupIdAndUser_UserId(UUID groupId, UUID userId);
    void deleteByGroup_GroupIdAndUser_UserId(UUID groupId, UUID userId);
}
