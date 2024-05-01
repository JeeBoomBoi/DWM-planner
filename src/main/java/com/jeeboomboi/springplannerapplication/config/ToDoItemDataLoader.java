package com.jeeboomboi.springplannerapplication.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jeeboomboi.springplannerapplication.models.ToDoItem;
import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;

@Component
// Spring Boot recognises on setup
public class ToDoItemDataLoader implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(ToDoItemDataLoader.class);
    
    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if (toDoItemRepository.count() == 0) {
            ToDoItem item1 = new ToDoItem("Get the milk");
            ToDoItem item2 = new ToDoItem("Leave the house");
            
            toDoItemRepository.save(item1);
            toDoItemRepository.save(item2);
        }

        logger.info("Number of TodoItems: {}", toDoItemRepository.count());
    }

}
