package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.login.sales.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByname(String name);
	/*@Modifying
	@Query(value="DELETE FROM Product p WHERE p.id= :id")
	public void deleteProductById(@Param("id") long id);*/
	
//	public void deleteById(Long Id);
}
