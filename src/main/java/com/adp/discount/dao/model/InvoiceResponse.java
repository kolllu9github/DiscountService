package com.adp.discount.dao.model;

import java.util.ArrayList;
import java.util.List;

import com.adp.discount.controller.DiscountLineItem;

public class InvoiceResponse {

//	private List<DiscountLineItem> lineItemLst = new ArrayList<>();
	private long discountedTotal;
	public long getDiscountedTotal() {
		return discountedTotal;
	}


	public void setDiscountedTotal(long discountedTotal) {
		this.discountedTotal = discountedTotal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private String name;
//	private long actualTotal;
//	private long itemTotal;
//	private float totalDiscount;
	//private String bestDiscount;

	public InvoiceResponse(long discountedTotal, String name) {
		super();
		this.discountedTotal = discountedTotal;
		this.name = name;
//		this.actualTotal = actualTotal;
//		this.itemTotal = itemTotal;
//		this.totalDiscount = totalDiscount;
		//this.bestDiscount= bestDiscount;
	}


//	public List<DiscountLineItem> getLineItemLst() {
//		return lineItemLst;
//	}
//	public void setLineItemLst(List<DiscountLineItem> lineItemLst) {
//		this.lineItemLst = lineItemLst;
//	}
//	public long getDiscountedTotal() {
//		return discountedTotal;
//	}
//	public void setDiscountedTotal(long discountedTotal) {
//		this.discountedTotal = discountedTotal;
//	}
//	public long getActualTotal() {
//		return actualTotal;
//	}
//	public void setActualTotal(long actualTotal) {
//		this.actualTotal = actualTotal;
//	}
//	public long getItemTotal() {
//		return itemTotal;
//	}
//	public void setItemTotal(long itemTotal) {
//		this.itemTotal = itemTotal;
//	}


//	public float getTotalDiscount() {
//		return totalDiscount;
//	}
//
//
//	public void setTotalDiscount(float totalDiscount) {
//		this.totalDiscount = totalDiscount;
//	}


//	public String getBestDiscount() {
//		return bestDiscount;
//	}
//
//
//	public void setBestDiscount(String bestDiscount) {
//		this.bestDiscount = bestDiscount;
//	}







}
