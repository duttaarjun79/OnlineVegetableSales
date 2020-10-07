package com.login.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.dao.ProductRepository;
import com.login.sales.model.Admin;
import com.login.sales.model.Customer;
import com.login.sales.model.Feedback;
import com.login.sales.model.Product;
import com.login.sales.service.AdminService;
import com.login.sales.service.CustomerService;
import com.login.sales.service.FeedbackService;
import com.login.sales.service.ProductService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService prodService;
	
	@Autowired
    ProductRepository productRepo;
	
	@Autowired
	FeedbackService feedbackService;
	
	@RequestMapping("/login")
	public Admin login(@RequestBody Admin admin) throws Exception
	{
		 String tempusername=admin.getUsername();
		  String temppassword=admin.getPassword();
		  Admin aobj=null;
		  if(tempusername != null && temppassword != null) 
		  {
			  aobj= adminService.findByusernameandpassword(tempusername, temppassword);
		  }
		  if(aobj == null)
		  {
			  throw new Exception("Bad Credentials");
		  }
		  return aobj;
	}
	
	  @GetMapping("/allcustomers")
	  public List<Customer> showall()
	  {
		  return customerService.listall();
	  }
	  
	  @GetMapping("/allproducts")
	  public List<Product> getall()
	  {
		  return prodService.getAllProducts();
	  }
	  
	  @PostMapping("/addveggies")
	  public Product addVeggies(@RequestBody Product prod) throws Exception{
		  String tempusername = prod.getName();
		  if(tempusername != null && "".equals(tempusername))
		  {
			  Product p= prodService.findSpecific(tempusername);
			  if(p != null)
			  {
				  throw new Exception("Vegatable already present with"+ tempusername +" Name" );
			  }
		  }
		  Product pobj = prodService.saveVeggies(prod);
		  return pobj;
	  }
	  
	  /*@DeleteMapping("/deleteVegById/{id}")
	  public void deleteVegById(@Validated @RequestBody Product prod, @PathVariable long id) {
		  System.out.println(id);
		  prodService.deleteProd(id);
	  }*/
	  
	  
	  /*@DeleteMapping("allproducts/deletes/{id}")

      public Product deleteProduct(@RequestBody Product prod,@PathVariable("id") long id) {

          prod = productRepo.getOne(id);

          productRepo.deleteById(id);

          return prod;

      }*/
	  
	  /*@DeleteMapping("allproducts/delete/{id}")
		public ResponseEntity<Void> deleteVegetable(@RequestBody Product prod,@PathVariable(value="id") long id) 
		{
		  	System.out.println(id);
			 prodService.delete(id);
			 return ResponseEntity.noContent().build();
			 
		}*/
	  
	  @GetMapping("/allfeedbacks")

	  public List<Feedback> viefeedbacks(){
	  
		  return feedbackService.getAllFeedbacks();
	  }
}
