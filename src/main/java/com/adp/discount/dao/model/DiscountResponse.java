package com.adp.discount.dao.model;

public class DiscountResponse {
	
	private String discountName;
	private long totalCost;
	
	public DiscountResponse(String name,  long totalCost) {
		super();
		this.discountName = name;
		this.totalCost = totalCost;
	}
	
	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

}
