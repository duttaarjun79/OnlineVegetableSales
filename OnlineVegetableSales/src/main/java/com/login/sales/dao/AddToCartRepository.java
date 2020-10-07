package com.login.sales.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.login.sales.model.AddToCart;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long>{

	@Query("Select sum(addtoCart.price) FROM AddToCart addtoCart WHERE addtoCart.user_id=:user_id")
	double getTotalAmountByUserId(@Param("user_id")Long user_id);
	@Query("Select addtoCart  FROM AddToCart addtoCart WHERE addtoCart.user_id=:user_id")
	List<AddToCart> getCartByuserId(@Param("user_id")Long user_id);
	@Query("Select addtoCart  FROM AddToCart addtoCart ")
	Optional<AddToCart> getCartByuserIdtest();
	@Query("Select addtoCart  FROM AddToCart addtoCart WHERE addtoCart.product.id= :product_id and addtoCart.user_id=:user_id")
	Optional<AddToCart> getCartByProductIdAnduserId(@Param("user_id")Long user_id,@Param("product_id")Long product_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddToCart addtoCart WHERE addtoCart.id =:cart_id   and addtoCart.user_id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddToCart addtoCart WHERE   addtoCart.user_id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")Long user_id);
	@Modifying
    @Transactional
	@Query("update AddToCart addtoCart set addtoCart.qty=:qty,addtoCart.price=:price WHERE addtoCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("qty")Integer qty);
}
