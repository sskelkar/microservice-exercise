package com.globomart.productcatalogue.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.domain.Product;
import com.globomart.productcatalogue.repository.ProductRepository;
import com.globomart.productcatalogue.service.price.PriceServiceHandler;

/**
 * Service class to hold business logic related to products.
 *
 * @author S.Kelkar
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
		
	@Autowired
	private PriceServiceHandler priceServiceHandler;
	
	/**
	 * Method to save a new product.
	 * @param product
	 */
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	/**
	 * Method to delete a product corresponding to the given product id.
	 * @param productId
	 */
	public void deleteProduct(Long productId) {
		productRepository.delete(productId);
	}
	
	/**
	 * Method to get all products with their respective prices.
	 * 
	 * @return list of Products
	 */
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		for(Product product : products) {		  
		  product.setPrice(priceServiceHandler.getPrice(product.getId()));
		}
		
		return products;
	}
	
	/**
	 * Method to get a product with its price.
	 * 
	 * @param productId
	 * @return product
	 */
	public Product getById(Long productId) {
		Product product = productRepository.findOne(productId);
		product.setPrice(priceServiceHandler.getPrice(productId));
		return product;
	}
	
	/**
	 * Get products with respect to some filter criteria.
	 * 
	 * @param productFilter
	 * @return filtered products
	 */
	public List<Product> search(Product productFilter) {
		List<Product> filtered = new ArrayList<>();
		Iterator<Product> it = getAllProducts().iterator();
		
		while(it.hasNext()) {
			Product next = it.next();
			if((productFilter.getId() != null && productFilter.getId().equals(next.getId()))
					|| (productFilter.getName() != null && productFilter.getName().equals(next.getName()))
					|| (productFilter.getType() != null && productFilter.getType().equals(next.getType()))) {
				filtered.add(next);
			}
		}
		return filtered;
	}
}
