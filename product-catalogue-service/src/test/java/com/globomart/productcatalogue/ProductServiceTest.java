package com.globomart.productcatalogue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.globomart.productcatalogue.client.PriceClient;
import com.globomart.productcatalogue.database.ProductRepository;
import com.globomart.productcatalogue.domain.Product;
import com.globomart.productcatalogue.domain.ProductType;
import com.globomart.productcatalogue.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	@Mock
	private PriceClient	priceClient;
	
	@InjectMocks
	private ProductService productService;
	
	private List<Product> dummyProducts = new ArrayList<>();
	@Before
	public void init() {
		dummyProducts.add(new Product(1L, "example", ProductType.GARMENTS));
		dummyProducts.add(new Product(1L, "abc", ProductType.ELECTRONIC));
		
		Mockito.when(productRepository.getAllProducts()).thenReturn(dummyProducts);
	}
	
	@Test
	public void testProductFilter() {
		Product productFilter = new Product();
		productFilter.setType(ProductType.ELECTRONIC);
		
		List<Product> filterd = productService.search(productFilter);
		Assert.assertTrue("filter is owkring", filterd.size() == 1);
	}
}
