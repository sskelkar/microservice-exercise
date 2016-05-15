package com.globomart.productcatalogue.domain;

public class Product {

	private Long id;
	
	private String name;
	
	private ProductType type;

	private Price price;
	
	public Product() {}
	public Product(Long id, String name, ProductType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}
	
	
}
