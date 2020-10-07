package com.login.sales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.login.sales.model.CheckOutCart;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOutCart, Long>{

	@Query("Select checkCart  FROM CheckOutCart checkCart WHERE checkCart.user_id=:user_id")
	List<CheckOutCart> getByuserId(@Param("user_id")Long user_id);
}
