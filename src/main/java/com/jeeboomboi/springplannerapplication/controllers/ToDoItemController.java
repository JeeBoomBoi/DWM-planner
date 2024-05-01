package com.jeeboomboi.springplannerapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;


@Controller
public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("GET home page");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("toDoItems", toDoItemRepository.findAll());
        System.err.println(modelAndView.getModelMap());
        return modelAndView;
    }
    

}
