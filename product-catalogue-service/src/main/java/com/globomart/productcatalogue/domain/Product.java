package com.globomart.productcatalogue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="product")
public class Product {

  @Id
  @Column(name = "product_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
  @SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ProductType type;
	
	public Product() {
	  // default constructor
	}
	
	@Transient
	private Price price;
	
	public Product(Long id, String name, ProductType type) {
		this.id = id;
		this.name = name;
		this.type = type;
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

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
	
	
}
