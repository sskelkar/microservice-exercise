package com.globomart.productcatalogue.price;

import com.globomart.productcatalogue.domain.Price;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * A HystrixCommand implementation to call price-service via Feign client. This implementation specifies a fallback mechanism in case of failure in making the network call.
 * 
 * The visibility of all the methods in this class is limited to package level as most. This is because this class is meant to be instantiated only via a builder class provided in the same package.
 *  
 * @author S.Kelkar
 */
  /*default */ class PriceCommand extends HystrixCommand<Price>{
  
  private static final Price DEFAULT_PRICE = new Price(-1.0, "Price couldn't be retrieved at this time. Please try again!");
  
  private PriceClient priceClient;
  
  private Long productId;
  
  PriceCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("PriceCommand"));
  }
  
  void setPriceClient(PriceClient priceClient) {
    this.priceClient = priceClient;
  }
  
  void setProductId(Long productId) {    
    this.productId = productId;
  }
  
  @Override
  protected Price run() throws Exception {
    return this.priceClient.getPriceForProduct(this.productId);
  }
  
  @Override
  protected Price getFallback() {    
    return DEFAULT_PRICE;
  }
}
