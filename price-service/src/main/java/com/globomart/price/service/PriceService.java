package com.globomart.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.price.domain.Price;
import com.globomart.price.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	public List<Price> getAllPrices() {
		return priceRepository.findAll();
	}
	
	
 	public Price getPriceByProductId(Long productId) {
		return priceRepository.findByProductId(productId);
 	}
}
