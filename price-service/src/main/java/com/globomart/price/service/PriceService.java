package com.globomart.price.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.price.database.PriceRepository;
import com.globomart.price.domain.Price;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	public List<Price> getAllPrices() {
		return priceRepository.getAllPrices();
	}
 	public Price getPriceByProductId(Long productId) {
		Iterator<Price> it = getAllPrices().iterator();
		
		while(it.hasNext()) {
			Price next = it.next();
			if(next.getProductId().equals(productId)) {
				return next;
			}
		}
		return null;
	}
}
