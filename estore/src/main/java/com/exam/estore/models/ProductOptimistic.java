package com.exam.estore.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOptimistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
	private Company company;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

    @Column(precision=10, scale=2)
	private BigDecimal price; 

    private int stock;

    @Version
    private Long version;
}
