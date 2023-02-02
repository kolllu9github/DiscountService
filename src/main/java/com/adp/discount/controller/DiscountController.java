package com.adp.discount.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adp.discount.dao.DiscountRepository;
import com.adp.discount.dao.model.Discounts;
import com.adp.discount.dao.model.InvoiceRequest;
import com.adp.discount.dao.model.InvoiceResponse;

@RestController
public class DiscountController {
	static List<AbstractDiscount> discountList = new ArrayList<>();
	@Autowired
	private DiscountRepository discountRepository;
	static {
		DiscountByType discountByItemType = new DiscountByType("ABC");
		DiscountByItem discountByItem = new DiscountByItem("FGH");
		DiscountByTotal discountByTotal = new DiscountByTotal("CDE");

		discountList.add(discountByItemType);
		discountList.add(discountByItem);
		discountList.add(discountByTotal);

	}

	private static Logger log = LoggerFactory.getLogger(DiscountController.class);


	@PostMapping(value = "/saveDiscount",
			produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveDiscount(@RequestBody Discounts discount) {
		discountRepository.save(discount);
		return "Discount saved--";
	}

	@DeleteMapping("/deleteDiscount/{name}")
	private String deleteDiscount(@PathVariable("name") String name)
	{
		discountRepository.deleteById(name);
		return "Discount deleted--";
	}

	@PostMapping(value = "/getBestDiscount",
			produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvoiceResponse getBestDiscount(@RequestBody List<InvoiceRequest> requestList) {

		//List<Discounts> discountList1= discountRepository.findAll();
		log.info("Received request {}",requestList);
		long totalAmount=0;
		String discountName="";

		for (AbstractDiscount abstractDiscount : discountList) {
			long tempDisc =0;
			for(InvoiceRequest request: requestList){
				long discount = abstractDiscount.calculateDiscount(request);
				tempDisc += discount!=0?(request.getQuantity()*request.getCost()*(100-discount))/100:(request.getQuantity()*request.getCost());
				
			}
			if(totalAmount==0 || totalAmount>tempDisc) {
				totalAmount=tempDisc;
				discountName=abstractDiscount.getName();
			}
			

		}
		InvoiceResponse response = new InvoiceResponse(totalAmount, discountName);

		return response;
	}

}
