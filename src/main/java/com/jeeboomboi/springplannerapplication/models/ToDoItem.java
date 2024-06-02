package com.jeeboomboi.springplannerapplication.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public static final List<String> list = Collections.unmodifiableList(
    new ArrayList<String>() {{
        add("Daily");
        add("Weekly");
        add("Monthly");
        // etc
    }});

    private String toDoType;

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
        return String.format("TodoItem{id=%d, description=%s, complete=%s, createdDate=%s, modifiedDate=%s, category=%s, todotype=%s}", 
        id, 
        description,
        complete,
        createdDate,
        modifiedDate,
        category,
        toDoType);
    }
}
