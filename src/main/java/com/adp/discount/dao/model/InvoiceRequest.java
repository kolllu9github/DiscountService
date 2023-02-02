package com.adp.discount.dao.model;

public class InvoiceRequest {

	private int id;
	private String type;
	private long cost;
	private int quantity;

	public InvoiceRequest(){}


	public InvoiceRequest(int id, String type, long cost, int quantity) {
		super();
		this.id = id;
		this.type = type;
		this.cost = cost;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





}
