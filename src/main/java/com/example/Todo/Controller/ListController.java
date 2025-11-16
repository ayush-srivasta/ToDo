package com.example.Todo.Controller;


import com.example.Todo.Entity.ListEntity;
import com.example.Todo.Service.ListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/lists")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }
    @PostMapping
    public ListEntity createList(@RequestParam UUID createdBy,
                                 @RequestParam(required = false) UUID userId,
                                 @RequestParam(required = false) UUID groupId,
                                 @RequestParam String title,
                                 @RequestParam(required = false) String description,
                                 @RequestParam String listType) {
        return listService.createList(createdBy, userId, groupId, title, description, listType);
    }

    @GetMapping("/user/{userId}")
    public List<ListEntity> getUserLists(@PathVariable UUID userId) {
        return listService.getListsForUser(userId);
    }

    @GetMapping("/group/{groupId}")
    public List<ListEntity> getGroupLists(@PathVariable UUID groupId) {
        return listService.getListsForGroup(groupId);
    }

    @GetMapping("/{listId}")
    public ListEntity getList(@PathVariable UUID listId) {
        return listService.getList(listId);
    }

    @PatchMapping("/{listId}")
    public ListEntity updateList(@PathVariable UUID listId,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String description) {
        return listService.updateList(listId, title, description);
    }

    @DeleteMapping("/{listId}")
    public void deleteList(@PathVariable UUID listId) {
        listService.deleteList(listId);
    }

}
