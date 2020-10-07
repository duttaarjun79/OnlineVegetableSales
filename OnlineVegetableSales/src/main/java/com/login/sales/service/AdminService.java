package com.login.sales.service;

import java.util.List;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sales.model.Admin;
import com.login.sales.model.Customer;
import com.login.sales.dao.AdminRepository;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private  final AdminRepository adminRepository;
	
	 public AdminService(AdminRepository adminRepository) {
		// TODO Auto-generated constructor stub
		this.adminRepository=adminRepository;
	}
	 
	 public Admin findByusernameandpassword(String username, String password) {
			return adminRepository.findByUsernameAndPassword(username, password);
		}
	 public List<Admin> listall(){
			return adminRepository.findAll();
		}

}
