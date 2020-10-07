package com.login.sales.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.http.MediaType;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.model.Product;
import com.login.sales.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/customer")
public class ProductController {

	@Autowired
	ProductService productservices;

	@RequestMapping("/getAll")
	public List<Product> getAllProduct(){
		return productservices.getAllProducts();
	}

}
