package com.globomart.productcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.productcatalogue.domain.Product;
import com.globomart.productcatalogue.service.ProductCatalogueService;

@RestController
@RequestMapping("/product")
public class ProductCatalogueController {

	@Autowired
	private ProductCatalogueService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="/{id}")
	public void deleteProduct(@PathVariable("id") Long productId) {
		productService.deleteProduct(productId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getAll() {
		return productService.getAllProducts();
	}

	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public Product getById(@PathVariable("id") Long id) {
		return productService.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/search")
	public List<Product> search(Product filter) {
		return productService.search(filter);
	}
}
