package com.globomart.productcatalogue.domain;

public class Price {
	private Double value;
	private String comment;
	
	public Price() {
	  // default constructor
	}
	public Price(Double value, String comment) {
	  this.value = value;
	  this.comment = comment;
	}
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
	
	
}
