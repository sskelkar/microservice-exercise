package com.globomart.productcatalogue.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.client.PriceClient;
import com.globomart.productcatalogue.database.ProductRepository;
import com.globomart.productcatalogue.domain.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PriceClient priceClient;
	
	public void addProduct(Product product) {
		productRepository.add(product);
	}
	
	public void deleteProduct(Long productId) {
		productRepository.delete(productId);
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.getAllProducts();
		
		for(Product product : products) {
			product.setPrice(priceClient.getPriceForProduct(product.getId()));
		}
		
		return products;
	}
	
	public Product getById(Long id) {
		Iterator<Product> it = getAllProducts().iterator();
		while(it.hasNext()) {
			Product curr = it.next();
			if(curr.getId() == id) {
				return curr;
			}
		}
		return null;
	}
	
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
