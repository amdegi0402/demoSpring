/**
 * customerController.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.spring4item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring4item.model.Customer;
import com.example.spring4item.service.CustService;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
@RestController
public class customerController {
	@Autowired
	private CustService custService;

	//全件検索
	@GetMapping("/customers")
	public List<Customer> getCustomer(){
		return custService.getAllCustomer();

	}
	//1件検索
	@GetMapping("/customers/{custId}")
	public Customer getCustomer(@PathVariable("custId") Long custId) {
		return custService.getCustomer(custId).orElseThrow(() -> new CustomerFoundException(custId));

	}
}
