package com.example.Todo.Service.Impl;

import com.example.Todo.Entity.ItemEntity;
import com.example.Todo.Entity.ListEntity;
import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Repository.ItemRepository;
import com.example.Todo.Repository.ListRepository;
import com.example.Todo.Repository.UserRepository;
import com.example.Todo.Service.ItemService;
import com.example.Todo.Service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ListRepository listRepository;
    private final UserRepository userRepository;

    public ItemServiceImpl(ItemRepository itemRepository,
                           ListRepository listRepository,
                           UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.listRepository = listRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ItemEntity addItem(UUID listId, UUID createdBy, String title, String attributes, int priority) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found"));
        UserEntity user = userRepository.findById(createdBy)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ItemEntity item = new ItemEntity();
        item.setList(list);
        item.setCreatedBy(user);
        item.setTitle(title);
        item.setAttributes(attributes);
        item.setPriority(priority);
        return itemRepository.save(item);
    }

    @Override
    public List<ItemEntity> getItemsForList(UUID listId) {
        return itemRepository.findByList_ListId(listId);
    }

    @Override
    public ItemEntity updateItem(UUID itemId, String title, Boolean isCompleted, String attributes, Integer priority) {
        ItemEntity item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (title != null) item.setTitle(title);
        if (isCompleted != null) item.setCompleted(isCompleted);
        if (attributes != null) item.setAttributes(attributes);
        if (priority != null) item.setPriority(priority);


        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(UUID itemId) {
        itemRepository.deleteById(itemId);
    }

}
