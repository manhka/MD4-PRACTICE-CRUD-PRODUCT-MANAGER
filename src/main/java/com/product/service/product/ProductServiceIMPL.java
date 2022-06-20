package com.product.service.product;

import com.product.model.Product;
import com.product.ropository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceIMPL implements IProductService{
    @Autowired
    IProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void remove(Long id) {
productRepository.deleteById(id);
    }

    public Iterable<Product> findByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Iterable<Product> top4() {
        return productRepository.getNewTop4();
    }

    public Iterable<Product> findProductByCategoryName(String categoryName) {
        return productRepository.findProductByCategoryName(categoryName);
    }
}
