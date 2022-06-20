package com.product.ropository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findByNameContaining(String name);
    @Query(value = "select * from product order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Product> getNewTop4();
    Iterable<Product> findProductByCategoryName(String nameCategory);
}
