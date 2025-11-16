package com.example.Todo.Controller;

import com.example.Todo.Entity.UserGroupEntity;
import com.example.Todo.Service.UserGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class UserGroupController {

    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @PostMapping
    public UserGroupEntity createGroup(@RequestParam UUID userId,
                                       @RequestParam String groupName,
                                       @RequestParam(required = false) String description) {
        return userGroupService.createGroup(userId, groupName, description);
    }

    @GetMapping
    public List<UserGroupEntity> getGroupsByUser(@RequestParam UUID userId) {
        return userGroupService.getGroupsByUser(userId);
    }

    @GetMapping("/{groupId}")
    public UserGroupEntity getGroupById(@PathVariable UUID groupId) {
        return userGroupService.getGroupById(groupId);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable UUID groupId) {
        userGroupService.deleteGroup(groupId);
    }

}
