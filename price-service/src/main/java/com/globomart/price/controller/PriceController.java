package com.globomart.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.price.domain.Price;
import com.globomart.price.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@RequestMapping(path="/product/{productId}", method = RequestMethod.GET)
	public Price getPriceForProduct(@PathVariable("productId") Long productId) {
	  
	  // following block is to simulate failure condition, in order to demonstrate open/close states of Hystrix circuit
	  {
	    if(Math.random() > 0.5)
	      throw new RuntimeException();
	  }
	  
		return priceService.getPriceByProductId(productId);
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public List<Price> getAllPrices() {
		return priceService.getAllPrices();
	}
}
