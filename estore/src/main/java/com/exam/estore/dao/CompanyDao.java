package com.exam.estore.dao;

import com.exam.estore.models.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "companies", path = "companies")
public interface CompanyDao extends JpaRepository<Company, Integer> {
}
