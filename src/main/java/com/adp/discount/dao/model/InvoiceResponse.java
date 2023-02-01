package com.adp.discount.dao.model;

import java.util.ArrayList;
import java.util.List;

import com.adp.discount.controller.DiscountLineItem;

public class InvoiceResponse {
	
	private List<DiscountLineItem> lineItemLst = new ArrayList<>();
	private long discountedTotal;
	private long actualTotal;
	private long itemTotal;
	private float totalDiscount;
	
	public InvoiceResponse(long discountedTotal, long actualTotal, long itemTotal, float totalDiscount) {
		super();
		this.discountedTotal = discountedTotal;
		this.actualTotal = actualTotal;
		this.itemTotal = itemTotal;
		this.totalDiscount = totalDiscount;
	}
	
	
	public List<DiscountLineItem> getLineItemLst() {
		return lineItemLst;
	}
	public void setLineItemLst(List<DiscountLineItem> lineItemLst) {
		this.lineItemLst = lineItemLst;
	}
	public long getDiscountedTotal() {
		return discountedTotal;
	}
	public void setDiscountedTotal(long discountedTotal) {
		this.discountedTotal = discountedTotal;
	}
	public long getActualTotal() {
		return actualTotal;
	}
	public void setActualTotal(long actualTotal) {
		this.actualTotal = actualTotal;
	}
	public long getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(long itemTotal) {
		this.itemTotal = itemTotal;
	}


	public float getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	
	
	
	
	
	

}
