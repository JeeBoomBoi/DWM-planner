package com.jeeboomboi.springplannerapplication.controllers;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.servlet.ModelAndView;

import com.jeeboomboi.springplannerapplication.models.ToDoItem;
import com.jeeboomboi.springplannerapplication.repositories.CategoryRepository;
import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String showCategories(Model model) {
        logger.info("GET home page");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("toDoItems", toDoItemRepository.findAll());
        return "index";
    }

    @GetMapping("/show-completed")
    public String showCompleted(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("toDoItems", toDoItemRepository.findAllByComplete(true));
        return "completed-items";
    }
    

    @PostMapping("/add-todo")
    public String addToDoItem(@Valid ToDoItem toDoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }

        toDoItem.setCreatedDate(LocalDateTime.now());
        toDoItem.setModifiedDate(LocalDateTime.now());
        toDoItemRepository.save(toDoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateToDoItem(@PathVariable("id") long id, @Valid ToDoItem toDoItem, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            toDoItem.setId(id);
            return "update-todo-item";
        }

        toDoItem.setModifiedDate(LocalDateTime.now());
        toDoItemRepository.save(toDoItem);
        return "redirect:/";
    }
}
