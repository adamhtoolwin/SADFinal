package com.exam.estore.dao;

import javax.persistence.LockModeType;

import com.exam.estore.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Product p where p.id = :id")
	Product findProductForWrite(@Param("id") int id);
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select p from Product p where p.id = :id")
	Product findProductForRead(@Param("id") int id);
}
