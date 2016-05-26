package com.globomart.productcatalogue.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.globomart.productcatalogue.domain.Price;
import com.globomart.productcatalogue.domain.Product;
import com.globomart.productcatalogue.domain.ProductType;
import com.globomart.productcatalogue.price.PriceServiceHandler;
import com.globomart.productcatalogue.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductCatalogueServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private PriceServiceHandler	priceServiceHandler;
	
	@InjectMocks
	private ProductCatalogueService productService;
	
	private Product GARMENT_1 = new Product(1L, "Jeans", ProductType.GARMENTS, new Price(10.0, null));
	private Product ELECTRONIC_1 = new Product(2L, "Stereo", ProductType.ELECTRONICS, new Price(10.0, null));
	private Product ELECTRONIC_FRIDGE = new Product(3L, "Fridge", ProductType.ELECTRONICS, new Price(10.0, null));
	
	@Before
	public void init() {		
		Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(GARMENT_1, ELECTRONIC_1, ELECTRONIC_FRIDGE));
		Mockito.when(productRepository.findOne(Matchers.anyLong())).thenReturn(GARMENT_1);
	}
	
	@Test
	public void filterElectornicItems() {
		Product productFilter = new Product();
		productFilter.setType(ProductType.ELECTRONICS);
		
		List<Product> filterd = productService.search(productFilter);
		Assert.assertTrue("filter electronic items", filterd.size() == 2);
		Assert.assertTrue("got electronic item 1", filterd.contains(ELECTRONIC_1));
		Assert.assertTrue("got electronic item 2", filterd.contains(ELECTRONIC_FRIDGE));
	}
	
	@Test
  public void filterGarmentsAndFridge() {
    Product productFilter = new Product();
    productFilter.setType(ProductType.GARMENTS);
    productFilter.setName("Fridge");
    
    List<Product> filterd = productService.search(productFilter);
    Assert.assertTrue("filter garments and items named 'Fridge'", filterd.size() == 2);   
    Assert.assertTrue("got garment", filterd.contains(GARMENT_1));
    Assert.assertTrue("got fridge", filterd.contains(ELECTRONIC_FRIDGE));
  }
	
	@Test
	public void getProductById() {
	  Product product = productService.getById(1L);
	  
	  Assert.assertTrue("get product with id 1", product.getId() == 1L);
	}
}
