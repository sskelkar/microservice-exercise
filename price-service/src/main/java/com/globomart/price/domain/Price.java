package com.globomart.price.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="price")
public class Price {

  @Id
  @Column(name = "price_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_price")
  @SequenceGenerator(name = "seq_price", sequenceName = "seq_price", allocationSize = 1)
	private Long id;
	
	private Long productId;
	
	private Double value;
	
	public Price() {
	  // default constructor
	}
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
