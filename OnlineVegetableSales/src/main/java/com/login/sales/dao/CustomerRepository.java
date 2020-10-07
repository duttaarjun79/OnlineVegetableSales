package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.login.sales.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
	
	public Customer findByusername(String username);
	
	public Customer findByUsernameAndPassword(String username, String password);
	
//	@Modifying
//	@Query(value="update Customer c set c.password= :password where c.username= :username ")
//	Customer changepassword(@Param("username") String username, @Param("password") String password); 

	//public Customer save(String name, String username, String email, String password);

}
