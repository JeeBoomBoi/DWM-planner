package com.jeeboomboi.springplannerapplication.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jeeboomboi.springplannerapplication.models.Category;
import com.jeeboomboi.springplannerapplication.models.ToDoItem;
import com.jeeboomboi.springplannerapplication.repositories.CategoryRepository;
import com.jeeboomboi.springplannerapplication.repositories.ToDoItemRepository;

@Component
// Spring Boot recognises on setup
public class DataLoader implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private CategoryRepository categoryRepository;

    
    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategorySeedData();
        loadToDoSeedData();
    }

    public void loadCategorySeedData() {
        if (categoryRepository.count() == 0) {
            Category item1 = new Category("Work", Long.valueOf(1));
            Category item2 = new Category("Friends and Family", Long.valueOf(2));
            Category item3 = new Category("Hustle", Long.valueOf(3));

            System.out.println("Creating category");
            
            categoryRepository.save(item1);
            categoryRepository.save(item2);
            categoryRepository.save(item3);
        }

        logger.info("Number of Categories: {}", categoryRepository.count());
    }

    public void loadToDoSeedData() {
        if (toDoItemRepository.count() == 0) {
            ToDoItem item1 = new ToDoItem("Get the milk");
            ToDoItem item2 = new ToDoItem("Leave the house");
            
            toDoItemRepository.save(item1);
            toDoItemRepository.save(item2);
        }

        logger.info("Number of TodoItems: {}", toDoItemRepository.count());
    }

}
