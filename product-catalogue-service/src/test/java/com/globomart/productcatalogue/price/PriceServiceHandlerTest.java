package com.globomart.productcatalogue.price;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.globomart.productcatalogue.domain.Price;


@RunWith(MockitoJUnitRunner.class)
public class PriceServiceHandlerTest {

  @Mock
  PriceCommandBuilder priceCommandBuilder;
  
  @Mock
  PriceCommand priceCommand;
  
  @InjectMocks
  PriceServiceHandler priceServiceHandler;
  
  @Test
  public void getPrice() {
    Price dummyPrice = new Price(10.0, null);
    
    Mockito.when(priceCommand.execute()).thenReturn(dummyPrice);
    Mockito.when(priceCommandBuilder.createPriceCommand()).thenReturn(priceCommandBuilder);
    Mockito.when(priceCommandBuilder.setProductId(Matchers.anyLong())).thenReturn(priceCommandBuilder);
    Mockito.when(priceCommandBuilder.build()).thenReturn(priceCommand);
    
    Price result = priceServiceHandler.getPrice(1L);
    
    Assert.assertTrue("correct price returned", result.getValue() == dummyPrice.getValue());
  }
}
