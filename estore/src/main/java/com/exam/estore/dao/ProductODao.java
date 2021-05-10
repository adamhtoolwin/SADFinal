package com.exam.estore.dao;

import com.exam.estore.models.ProductOptimistic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productOs", path = "productOs")
public interface ProductODao extends JpaRepository<ProductOptimistic, Integer> {
}
