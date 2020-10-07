package com.login.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sales.dao.FeedbackRepository;
import com.login.sales.model.Feedback;

@Service
public class FeedbackService {

	@Autowired 
	private FeedbackRepository feedbackRepo;
	
	public Feedback addFeedback(Feedback feedback, String emailId) {
		return feedbackRepo.save(feedback);
	}
	
	public List<Feedback>getAllFeedbacks(){
		 return feedbackRepo.findAll();
		 }
	
}
