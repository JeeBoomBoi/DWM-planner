package com.jeeboomboi.springplannerapplication.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="category")
@Data
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long category_id;

    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<ToDoItem> toDoList;

    public Category() {}

    public Category(String title, Long category_id) {
        this.title = title;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return String.format("String{id=%d, title=%s, category_id=%d}", id, title, category_id);
    }
}
