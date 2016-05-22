package com.globomart.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.price.domain.Price;
import com.globomart.price.repository.PriceRepository;

/**
 * Service class to handle prices.
 * 
 * @author S.Kelkar
 */
@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	/**
	 * Get all prices
	 * @return list of prices
	 */
	public List<Price> getAllPrices() {
		return priceRepository.findAll();
	}
	
	/**
	 * Get price for a given product id
	 * @param productId
	 * @return price
	 */
 	public Price getPriceByProductId(Long productId) {
		return priceRepository.findByProductId(productId);
 	}
}
