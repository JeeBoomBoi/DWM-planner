package com.jeeboomboi.springplannerapplication.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="todo_item")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private boolean complete;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public ToDoItem() {

    }

    public ToDoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description=%s, complete=%s, createdDate=%s, modifiedDate=%s}", 
        id, 
        description,
        complete,
        createdDate,
        modifiedDate);
    }
}
