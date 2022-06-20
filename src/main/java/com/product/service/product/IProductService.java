package com.product.service.product;

import com.product.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void remove(Long id);
    Iterable<Product> findByName(String name);
    Iterable<Product> top4();
    Iterable<Product> findProductByCategoryName(String categoryName);
}
