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
	
	public Discounts() {};
	
	public Discounts(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
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
	
}
