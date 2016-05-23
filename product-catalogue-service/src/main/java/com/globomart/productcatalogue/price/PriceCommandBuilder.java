package com.globomart.productcatalogue.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Builder class to create and initialize a hystrix command implementation instance to fetch price from price-service via Feign client. 
 * This class is package private because it deals with low level hystrix implemenation. Service classes shouldn't deal with this class directly.
 * 
 * @author S.Kelkar
 */
@Component
/*default*/ class PriceCommandBuilder {
  PriceCommand priceCommand;
  
  @Autowired
  private PriceClient priceClient;
  
  PriceCommandBuilder createPriceCommand() {
    this.priceCommand = new PriceCommand();
    this.priceCommand.setPriceClient(this.priceClient);
    return this;
  }
  
  PriceCommandBuilder setProductId(Long productId) {
    this.priceCommand.setProductId(productId);
    return this;
  }
  
  PriceCommand build() {
    return this.priceCommand;
  }
}
