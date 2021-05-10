package com.exam.estore.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Product> products;
}
