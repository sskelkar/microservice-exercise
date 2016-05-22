package com.globomart.productcatalogue.service.price;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.globomart.productcatalogue.client.PriceClient;
import com.globomart.productcatalogue.domain.Price;


@RunWith(MockitoJUnitRunner.class)
public class PriceCommandTest {

  private PriceCommand priceCommand;
  
  @Mock
  private PriceClient priceClient;
  
  @Before
  public void init() {
    priceCommand = new PriceCommand();
    priceCommand.setProductId(1L);
  }
  
  @Test 
  public void successfulExecution() {
    Price dummyPrice = new Price(25.0, null);    
    Mockito.when(priceClient.getPriceForProduct(Matchers.anyLong())).thenReturn(dummyPrice);
    priceCommand.setPriceClient(priceClient);
    
    Price result = priceCommand.execute();
    
    Assert.assertTrue("got valid result", result.getValue() == dummyPrice.getValue());
  }
  
  @Test
  public void testFallBack() {
    Mockito.when(priceClient.getPriceForProduct(Matchers.anyLong())).thenThrow(new RuntimeException());
    priceCommand.setPriceClient(priceClient);
    
    Price result = priceCommand.execute();
    Assert.assertTrue("got price from the fallback block", result.getComment().equals("Price couldn't be retrieved at this time. Please try again!"));
  }
}
