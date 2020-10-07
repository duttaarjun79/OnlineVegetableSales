package com.login.sales.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.login.sales.dao.CustomerRepository;
import com.login.sales.model.Customer;

@Service
@Transactional
public class CustomerService // implements UserDetailsService
{

	@Autowired
	private CustomerRepository custRepo;

//	public CustomerService(CustomerRepository custRepo)
//	{
//		this.custRepo=custRepo;
//	}

	public Customer savecustomer(Customer cust) {
		return custRepo.save(cust);
	}

	public Customer login(String username, String password) {
		return custRepo.findByUsernameAndPassword(username, password);
	}

	public Customer findspecific(String username) 
	{
		return custRepo.findByusername(username);
	}

	
//	public Customer editPassword(String username,String password)
//	{
//	   return custRepo.changepassword(username, password);
//	}
	  
	public List<Customer> listall() {
		return (List<Customer>) custRepo.findAll();
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Customer c = custRepo.findByusername(username);
//		 return new org.springframework.security.core.userdetails.User(c.getUsername(), c.getPassword(), new ArrayList<>());
//	}
}
