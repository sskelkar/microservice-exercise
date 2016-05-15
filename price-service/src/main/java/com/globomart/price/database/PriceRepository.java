package com.globomart.price.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.globomart.price.domain.Price;

@Component
public class PriceRepository {
	List<Price> priceDatabse = new ArrayList<>();
	
	public PriceRepository() {
		addDummyData();
	}
	public void add(Price price) {
		priceDatabse.add(price);
	}
	
	public List<Price> getAllPrices() {
		return priceDatabse;
	}
	private void addDummyData() {
		priceDatabse.add(new Price(1L, 2L, 10.0));
		priceDatabse.add(new Price(1L, 3L, 20.0));
	}
}
