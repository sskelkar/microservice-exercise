package com.globomart.productcatalogue.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globomart.productcatalogue.domain.Price;

@FeignClient("PRICE-SERVICE")
public interface PriceClient {

	@RequestMapping(path="/price/product", method = RequestMethod.GET)
	public Price getPriceForProduct(@RequestParam("id") Long productId);
}
