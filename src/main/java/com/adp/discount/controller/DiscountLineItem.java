package com.adp.discount.controller;

public class DiscountLineItem {
	
	private String name;
	private long discount;
	private long totalCost;
	private long discountedCost;
	private long quantity;
	
	
	
	public DiscountLineItem(String name, long discount, long totalCost, long discountedCost, long quantity) {
		super();
		this.name = name;
		this.discount = discount;
		this.totalCost = totalCost;
		this.discountedCost = discountedCost;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}


	public long getDiscountedCost() {
		return discountedCost;
	}


	public void setDiscountedCost(long discountedCost) {
		this.discountedCost = discountedCost;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
	

}
