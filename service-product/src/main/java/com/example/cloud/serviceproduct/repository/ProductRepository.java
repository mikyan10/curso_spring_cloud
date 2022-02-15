package com.example.cloud.serviceproduct.repository;

import com.example.cloud.serviceproduct.entity.Category;
import com.example.cloud.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
