package com.jeeboomboi.springplannerapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jeeboomboi.springplannerapplication.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
