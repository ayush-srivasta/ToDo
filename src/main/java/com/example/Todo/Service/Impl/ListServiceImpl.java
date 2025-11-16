package com.example.Todo.Service.Impl;

import com.example.Todo.Entity.ListEntity;
import com.example.Todo.Entity.UserEntity;
import com.example.Todo.Entity.UserGroupEntity;
import com.example.Todo.Repository.ListRepository;
import com.example.Todo.Repository.UserGroupRepository;
import com.example.Todo.Repository.UserRepository;
import com.example.Todo.Service.ListService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public ListServiceImpl(ListRepository listRepository, UserRepository userRepository, UserGroupRepository userGroupRepository) {
        this.listRepository = listRepository;
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public ListEntity createList(UUID createdBy, UUID userId, UUID groupId, String title, String description, String listType) {
        UserEntity creator = userRepository.findById(createdBy)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ListEntity list = new ListEntity();
        list.setCreatedBy(creator);
        list.setTitle(title);
        list.setDescription(description);
        list.setListType(listType);

        if (userId != null) {
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            list.setUser(user);
        }

        if (groupId != null) {
            UserGroupEntity group = userGroupRepository.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Group not found"));
            list.setGroup(group);
        }

        return listRepository.save(list);
    }

    @Override
    public List<ListEntity> getListsForUser(UUID userId) {
        return listRepository.findByUser_UserId(userId);
    }

    @Override
    public List<ListEntity> getListsForGroup(UUID groupId) {
        return listRepository.findByGroup_GroupId(groupId);
    }

    @Override
    public ListEntity getList(UUID listId) {
        return listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found"));
    }

    @Override
    public ListEntity updateList(UUID listId, String title, String description) {
        ListEntity list = getList(listId);
        if (title != null) list.setTitle(title);
        if (description != null)
            list.setDescription(description);

        return listRepository.save(list);
    }

    @Override
    public void deleteList(UUID listId) {
        listRepository.deleteById(listId);
    }

}
