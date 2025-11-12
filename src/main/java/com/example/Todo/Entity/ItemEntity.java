package com.example.Todo.Entity;

import com.example.Todo.Entity.ListEntity;
import com.example.Todo.Entity.UserEntity;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    private ListEntity list;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @Column(nullable = false)
    private String title;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted = false;

    @Column(name = "due_date")
    private Instant dueDate;

    @Column(name = "priority", nullable = false)
    private int priority = 0;
//    @Column(name = "attributes", columnDefinition = "jsonb")  use this when we will use Postgre SQL
    @Column(name = "attributes", columnDefinition = "TEXT")
    private String attributes; // store JSON (PostgreSQL)

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    // Getters & Setters
    public UUID getItemId() { return itemId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public ListEntity getList() { return list; }
    public void setList(ListEntity list) { this.list = list; }
}
