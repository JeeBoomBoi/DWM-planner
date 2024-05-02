package com.jeeboomboi.springplannerapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeeboomboi.springplannerapplication.models.ToDoItem;
import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;

@Controller
public class ToDoFormController {

    private final Logger logger = LoggerFactory.getLogger(ToDoFormController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        // Model is always passed in Spring Boot
        ToDoItem toDoItem = toDoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("toDoItem id: " + id + " not found."));

        model.addAttribute("todo", toDoItem);
        return "update-todo-item";
    }

}
