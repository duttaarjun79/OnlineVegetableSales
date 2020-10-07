package com.login.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.model.Customer;
import com.login.sales.model.Payment;
import com.login.sales.service.CustomerService;
import com.login.sales.service.PaymentService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/api/customer")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/{username}/payment")
	public Payment addcard(@Validated @RequestBody Payment pay,@PathVariable String username)
	{
		Customer customer = customerService.findspecific(username);
		pay.setCustomer(customer);
		return paymentService.savepayment(pay,username);
		
	}
}
