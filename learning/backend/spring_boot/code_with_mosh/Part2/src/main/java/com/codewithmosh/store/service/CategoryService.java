package com.codewithmosh.store.service;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    public CategoryRepository categoryRepository;

    public Category addCategory(int id) {
        Category category = new Category();
        category.setName("Category " + id);
        return categoryRepository.save(category);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

}
