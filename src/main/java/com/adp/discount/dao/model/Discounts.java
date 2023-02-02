package com.adp.discount.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DISCOUNTS")
public class Discounts {
	@Id
	@Column(name="NAME")
	private String name;
	
	@Column(name= "PERCENTAGE")
	private double percentage;
	
	@Column(name= "TYPE")
	private String type;
	
	@Column(name="TYPEVALUE")
	private String typeValue;
	
	public Discounts() {}

	public Discounts(String name, double percentage, String type, String typeValue) {
		this.name = name;
		this.percentage = percentage;
		this.type = type;
		this.typeValue = typeValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}


	

}
