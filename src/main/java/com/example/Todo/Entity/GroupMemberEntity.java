package com.example.Todo.Entity;

import com.example.Todo.Entity.UserEntity;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "group_members", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"group_id", "user_id"})
})
public class GroupMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_member_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID groupMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private UserGroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private String role = "member"; // owner/admin/member

    @Column(name = "joined_at", nullable = false)
    private Instant joinedAt = Instant.now();

    // Getters & Setters
    public UUID getGroupMemberId() { return groupMemberId; }
    public UserGroupEntity getGroup() { return group; }
    public void setGroup(UserGroupEntity group) { this.group = group; }
    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
