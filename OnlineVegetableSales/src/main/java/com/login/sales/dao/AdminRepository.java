package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.sales.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	public Admin findByUsernameAndPassword(String username, String password);
	
	
	
}
