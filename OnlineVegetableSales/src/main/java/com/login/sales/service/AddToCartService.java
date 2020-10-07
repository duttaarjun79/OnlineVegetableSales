package com.login.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.login.sales.dao.AddToCartRepository;
import com.login.sales.model.AddToCart;
import com.login.sales.model.CheckOutCart;
import com.login.sales.model.Product;

@Service
public class AddToCartService {

	@Autowired
	AddToCartRepository addCartRepo;
	@Autowired
	ProductService proServices;
    private static final Logger logger = LoggerFactory.getLogger(AddToCartService.class);


	public List<AddToCart> addCartbyUserIdAndProductId(long productId, long userId,int qty,double price) throws Exception {
		try {
			if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
				throw new Exception("Product is already exist.");
			}
			AddToCart obj = new AddToCart();
			obj.setQty(qty);
			obj.setUser_id(userId);
			Product pro = proServices.getProductsById(productId);
			obj.setProduct(pro); 
			//TODO price has to check with qty
			obj.setPrice(price);
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	public List<AddToCart> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

	public List<AddToCart> removeCartByUserId(long cartId, long userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}


	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}
	
	public List<AddToCart> removeAllCartByUserId(long userId) {
		addCartRepo.deleteAllCartByUserId(userId);
		return null;
	}
	
	public List<CheckOutCart> saveProductsForCheckout(List<CheckOutCart> tmp) throws Exception {
		return null;
	}
	
	public List<CheckOutCart> getAllCheckoutByUserId(long userId) throws Exception {
		return null;
	}

}
