package com.login.sales.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sales.dao.AddressRepository;
import com.login.sales.model.Address;

@Service
@Transactional
public class AddressService {

	@Autowired
	AddressRepository addRepo;
	
	public Address addAddress(Address add, String username)
	{
		return addRepo.save(add);
	}
}
