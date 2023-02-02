package com.adp.discount.controller;

import com.adp.discount.dao.model.InvoiceRequest;

public class DiscountByType extends AbstractDiscount {


	public DiscountByType(String name) {
		super.setName(name);
	}

	@Override
	protected long calculateDiscount(InvoiceRequest request) {
		// TODO Auto-generated method stub

		if(request.getType().toUpperCase().equals("CLOTHES")) {
			return 10;
		}
		return 0;

	}

}
