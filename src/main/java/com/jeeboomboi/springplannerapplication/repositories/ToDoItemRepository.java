package com.jeeboomboi.springplannerapplication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeeboomboi.springplannerapplication.models.ToDoItem;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {
    List<ToDoItem> findAllByComplete(boolean complete);
}
