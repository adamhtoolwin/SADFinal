package com.exam.estore.dao;

import com.exam.estore.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductDao extends JpaRepository<Product, Integer> {
    
}
