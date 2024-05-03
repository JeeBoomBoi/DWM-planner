package com.jeeboomboi.springplannerapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeeboomboi.springplannerapplication.models.ToDoItem;
import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;


@Controller
public class ToDoFormController {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/add-todo")
    public String showCreateForm(ToDoItem toDoItem) {
        return "add-todo-item";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        // Model is always passed in Spring Boot
        ToDoItem toDoItem = toDoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("toDoItem id: " + id + " not found."));

        model.addAttribute("todo", toDoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        ToDoItem todoItem = toDoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    
        toDoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}
