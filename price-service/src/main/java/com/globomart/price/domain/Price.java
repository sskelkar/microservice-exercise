package com.globomart.price.domain;

public class Price {

	private Long id;
	
	private Long productId;
	
	private Double value;
	
	public Price() {}
	public Price(Long id, Long productId, Double value) {
		this.id = id;
		this.productId = productId;
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
