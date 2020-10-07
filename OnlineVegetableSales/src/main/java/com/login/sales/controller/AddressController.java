package com.login.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.model.Address;
import com.login.sales.model.Customer;
import com.login.sales.service.AddressService;
import com.login.sales.service.CustomerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/api/customer")
public class AddressController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addServie;
	
	@PostMapping("/{username}/address")
	public Address addAddressCont(@Validated @RequestBody Address add, @PathVariable String username)
	{
		Customer customer = customerService.findspecific(username);
		add.setCustomer(customer);
		return addServie.addAddress(add,username);
	}
}

