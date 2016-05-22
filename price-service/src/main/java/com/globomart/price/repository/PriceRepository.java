package com.globomart.price.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globomart.price.domain.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Serializable>{
	Price findByProductId(Long productId);
}
