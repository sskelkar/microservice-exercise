package com.globomart.productcatalogue.price;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globomart.productcatalogue.domain.Price;

/**
 * FeignClient interface that declares the price-service REST calls that are needed to be called from product catalogue service.
 *
 * @author S.Kelkar
 */
@FeignClient("PRICE-SERVICE")
/*default*/ interface PriceClient {

	@RequestMapping(path="/price/product/{productId}", method = RequestMethod.GET)
	public Price getPriceForProduct(@PathVariable("productId") Long productId);
}
