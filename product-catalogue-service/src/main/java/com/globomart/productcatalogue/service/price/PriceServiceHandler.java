package com.globomart.productcatalogue.service.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globomart.productcatalogue.domain.Price;

/**
 * Publicly accessible class that provides methods useful to ProductService to interact with price-service. This way, ProductService remain oblivious to the low level implementation details
 * involving Hystrix and Feign. 
 * 
 * @author S.Kelkar
 */
@Component
public class PriceServiceHandler {

  @Autowired
  PriceCommandBuilder priceCommandBuilder;
  
  /**
   * Method to price for a product id.
   * @param productId
   * @return Price object
   */
  public Price getPrice(Long productId) {
    PriceCommand priceCommand = priceCommandBuilder.createPriceCommand().setProductId(productId).build();
    return priceCommand.execute();
  }
}
