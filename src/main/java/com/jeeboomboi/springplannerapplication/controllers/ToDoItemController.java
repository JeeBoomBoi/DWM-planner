package com.jeeboomboi.springplannerapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("GET home page");
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }
    

}
