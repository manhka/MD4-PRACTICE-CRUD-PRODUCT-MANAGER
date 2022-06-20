package com.product.service.category;

import com.product.model.Category;
import com.product.ropository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryServiceIMPL implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void remove(Long id) {
categoryRepository.deleteById(id);
    }
}
