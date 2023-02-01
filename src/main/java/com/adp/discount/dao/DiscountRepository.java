package com.adp.discount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adp.discount.dao.model.Discounts;

public interface DiscountRepository extends JpaRepository<Discounts,String>{
}
