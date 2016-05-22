package com.globomart.productcatalogue.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globomart.productcatalogue.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable>{

}
