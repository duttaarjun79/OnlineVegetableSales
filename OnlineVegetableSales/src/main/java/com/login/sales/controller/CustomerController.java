package com.login.sales.controller;

import java.util.List;

import org.aspectj.weaver.NewParentTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;

//import com.login.sales.model.AuthRequest;
import com.login.sales.model.Customer;
import com.login.sales.service.CustomerService;
//import com.logon.sales.util.JwtUtil;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
//	@Autowired
//    private JwtUtil jwtUtil;
//    @Autowired
//    private AuthenticationManager authenticationManager;
	  
	
	  @RequestMapping("/login")
	  public Customer login(@RequestBody Customer cust) throws Exception
	  { 
		  String tempusername=cust.getUsername(); 
		  String temppassword=cust.getPassword();
		  Customer cobj=null;
		  if(tempusername != null && temppassword != null)
		  {
			  cobj= customerService.login(tempusername,temppassword);
			  }
		  if(cobj == null)
		  { 
			  throw new Exception("Bad Credentials");
			  }
	  return cobj;
	  }
//	@GetMapping("/")
//	public String loggiinn() {
//		return "Hello User";
//	}
//	 
//	@PostMapping("/authenticate")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
//            );
//        } catch (Exception ex) {
//            throw new Exception("inavalid username/password");
//        }
//        return jwtUtil.generateToken(authRequest.getUserName());
//    }
	/*
	 * @RequestMapping("/login/{username") public Customer login(@PathVariable
	 * String username) {
	 * 
	 * return customerService.findspecific(username);
	 * 
	 * }
	 */
	  
	  @PostMapping("/register")
	  public Customer adddata(@RequestBody Customer cust) throws Exception{
		  String tempusername = cust.getUsername();
		  if(tempusername != null && "".equals(tempusername))
		  {
			  Customer c= customerService.findspecific(tempusername);
			  if(c != null)
			  {
				  throw new Exception("User already present with"+ tempusername +" username" );
			  }
		  }
		  Customer cobj = customerService.savecustomer(cust);
		  return cobj;
	  }
	  

//	 Change Password
//	  @PutMapping("/update") 
//	  public Customer updateEmployee( @RequestBody Customer cust) throws Exception
//	  {
//		  String tempusername=cust.getUsername(); 
//		  String temppassword=cust.getPassword();
//		  if(tempusername != null && "".equals(tempusername))
//		  {
//			  Customer c= customerService.findspecific(tempusername);
//			  if(c == null)
//			  {
//				  throw new Exception("User not found with"+ tempusername +" username" );
//			  }  
//		  }
//		  Customer cobj= customerService.editPassword(tempusername, temppassword);
//		  return cobj;
//	  }
}
