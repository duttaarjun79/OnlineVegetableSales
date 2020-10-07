package com.login.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.model.Customer;
import com.login.sales.model.Feedback;
import com.login.sales.service.CustomerService;
import com.login.sales.service.FeedbackService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/{username}/comments")
	@CrossOrigin(origins = "http://localhost:4200")
	public Feedback addFeedback(@PathVariable String username,
			 @Validated @RequestBody Feedback feedback) throws NotFoundException {
					Customer customer = customerService.findspecific(username);
                	feedback.setCustomer(customer);
                    return feedbackService.addFeedback(feedback, username);
               
	}
}
