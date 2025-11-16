package com.example.Todo.Controller;

import com.example.Todo.Entity.GroupMemberEntity;
import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Service.GroupMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/groups/{groupId}/members")
public class GroupMemberController {

    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @GetMapping
    public List<UserEntity> listMembers(@PathVariable UUID groupId) {
        return groupMemberService.getMembersByGroup(groupId);
    }

    @PostMapping
    public GroupMemberEntity addMember(@PathVariable UUID groupId,
                                       @RequestParam UUID userId,
                                       @RequestParam(required = false) String role) {
        return groupMemberService.addMember(groupId, userId, role);
    }

    @DeleteMapping("/{userId}")
    public void removeMember(@PathVariable UUID groupId, @PathVariable UUID userId) {
        groupMemberService.removeMember(groupId, userId);
    }
}
