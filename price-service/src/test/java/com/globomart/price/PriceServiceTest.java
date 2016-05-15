package com.globomart.price;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.globomart.price.database.PriceRepository;
import com.globomart.price.domain.Price;
import com.globomart.price.service.PriceService;


@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

	@Mock
	private PriceRepository priceRepository;
	
	@InjectMocks
	private PriceService priceService;
	
	private List<Price> dummyPrices;
	@Before
	public void init() {
		dummyPrices = new ArrayList<>();
		dummyPrices.add(new Price(1L, 2L, 5.0));
		dummyPrices.add(new Price(2L, 3L, 10.0));
		dummyPrices.add(new Price(3L, 5L, 15.0));
		Mockito.when(priceRepository.getAllPrices()).thenReturn(dummyPrices);
		
	}
	@Test
	public void getAllPrices() {
		Assert.assertTrue("all prices are returned", priceService.getAllPrices().size() == dummyPrices.size());
	}
	
	@Test
	public void testPriceByFilterId() {
		Price result = priceService.getPriceByProductId(5L);
		
		Assert.assertTrue("price for product id 5 is returned", result.getProductId() == 5L);
	}
}
