package com.product.service.category;

import com.product.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional  <Category> findById(Long id);
    Category save(Category category);
    void remove(Long id);

}
