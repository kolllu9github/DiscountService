package com.adp.discount.controller;

import com.adp.discount.dao.model.InvoiceRequest;

public class DiscountByItem extends AbstractDiscount {


	public DiscountByItem(String name) {
		super.setName(name);
	}


	@Override
	protected long calculateDiscount(InvoiceRequest request) {
		// TODO Auto-generated method stub

		if(request.getId()==123 && request.getQuantity() > 1) {
			//super.setBestDiscount(20);
			return 20;
		}
		return 0;
	}

}
