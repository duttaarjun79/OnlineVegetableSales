package com.login.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sales.dao.PaymentRepository;
import com.login.sales.model.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	public Payment savepayment(Payment pay, String username)
	{
		return paymentRepo.save(pay);
	}

}
