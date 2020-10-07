package com.login.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sales.dao.ProductRepository;
import com.login.sales.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	
		public List<Product>getAllProducts(){
			return productRepo.findAll();
		}
		
		public Product getProductsById(long productId) throws Exception {
			return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
		}
		
		public Product findSpecific(String name)
		{
			return productRepo.findByname(name);
		}
		
		public Product saveVeggies(Product prod)
		{
			return productRepo.save(prod);
		}
		public void delete(long id)
		{
			productRepo.deleteById(id);
		}
		
		/*public void deleteProd(long id) {
			productRepo.deleteProductById(id);
			//productRepo.delete(entity);
		}*/
}
