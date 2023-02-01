package com.adp.discount.controller;

import com.adp.discount.dao.model.DiscountRequest;
import com.adp.discount.dao.model.InvoiceRequest;

public abstract class AbstractDiscount {
	

	
	private long bestDiscount;
	
	private String name;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getBestDiscount() {
		return bestDiscount;
	}

	public void setBestDiscount(long bestDiscount) {
		this.bestDiscount = bestDiscount;
	}


	protected abstract long calculateDiscount( InvoiceRequest request);
	
}