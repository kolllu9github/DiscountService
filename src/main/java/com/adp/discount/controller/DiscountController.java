package com.adp.discount.controller;

import java.util.ArrayList;
import java.util.List;

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
		
		log.info("Received request {}",requestList);
		
		
		
		List<DiscountLineItem> discountedItemLst = new ArrayList<>();
		
		for(InvoiceRequest request: requestList){
			
			DiscountLineItem response1 = getBestDiscountPerRequest(request);
			
			discountedItemLst.add(response1);
		}
		
		long totalDiscountCost = 0;
		long totalActual = 0;
		long totalQty = 0;
		float totalDiscount = 0;
		for(DiscountLineItem lineItem: discountedItemLst) {
			
			totalDiscountCost += lineItem.getDiscountedCost();
			totalActual += lineItem.getTotalCost();
			totalQty += lineItem.getQuantity();
		}
		totalDiscount = (( (float)totalActual - (float)totalDiscountCost) /  (float)totalActual) * 100;
		
		log.info("totalDiscount minus {}",totalActual - totalDiscountCost);
		log.info("totalDiscount in percentage {}",totalDiscount);
		
		InvoiceResponse response = new InvoiceResponse(totalDiscountCost, totalActual, totalQty,totalDiscount);
		response.setLineItemLst(discountedItemLst);
		
		return response;
	}
	
	
	private DiscountLineItem getBestDiscountPerRequest(InvoiceRequest request) {
		
		
		long bestDiscount = 0;
		long tempDisc = 0;
		
		AbstractDiscount finalDiscount = null; 
		
		for (AbstractDiscount abstractDiscount : discountList) {
			tempDisc = abstractDiscount.calculateDiscount(request);
			if(tempDisc > bestDiscount) {
				bestDiscount = tempDisc;
				finalDiscount = abstractDiscount;
			}
			
		}
		
		
		log.info("Best Discount for the request {} is {}",request,bestDiscount );
		
		long total = (long) (request.getCost() * request.getQuantity());
		long discountedCost = total - (total * bestDiscount/100);
		
		DiscountLineItem response = new DiscountLineItem(finalDiscount.getName(),bestDiscount,total,discountedCost,request.getQuantity());

		return response;
		
	}

}
