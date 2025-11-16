package com.example.Todo.Controller;


import com.example.Todo.Entity.ItemEntity;
import com.example.Todo.Service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/items/{itemId}")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/items")
    public ItemEntity addItem(@PathVariable UUID listId,
                              @RequestParam UUID createdBy,
                              @RequestParam String title,
                              @RequestParam(required = false) String attributes,
                              @RequestParam(defaultValue = "0") int priority) {
        return itemService.addItem(listId, createdBy, title, attributes, priority);
    }

    @GetMapping("/items")
    public List<ItemEntity> getItems(@PathVariable UUID listId) {
        return itemService.getItemsForList(listId);
    }

    @PatchMapping()
    public ItemEntity updateItem(@PathVariable UUID itemId,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) Boolean isCompleted,
                                 @RequestParam(required = false) String attributes,
                                 @RequestParam(required = false) Integer priority) {
        return itemService.updateItem(itemId, title, isCompleted, attributes, priority);
    }

    @DeleteMapping()
    public void deleteItem(@PathVariable UUID itemId) {
        itemService.deleteItem(itemId);
    }
}
