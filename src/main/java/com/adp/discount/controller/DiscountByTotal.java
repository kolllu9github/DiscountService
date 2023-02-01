package com.adp.discount.controller;

import com.adp.discount.dao.model.DiscountRequest;
import com.adp.discount.dao.model.InvoiceRequest;

public class DiscountByTotal extends AbstractDiscount {
	
	
	public DiscountByTotal(String name) {
		super.setName(name);
	}



	@Override
	protected long calculateDiscount(InvoiceRequest request) {
		// TODO Auto-generated method stub

		Long total = (long) (request.getCost() * request.getQuantity());
		
		if(total > 100) {
			return 15; 
		}
		return 0;

	}

}
