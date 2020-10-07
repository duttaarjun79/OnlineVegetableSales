package com.login.sales.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.login.sales.dao.FeedbackRepository;
import com.login.sales.model.Feedback;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@MockBean
	private FeedbackRepository feedbackRepo;
	
	@Test
	public void testAddFeedback() {
		Feedback feedback = new Feedback();
		feedback.setId(1);
		feedback.setComments("Good Items");
		feedback.setRating(4);
		
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		assertThat(feedbackService.addFeedback(feedback, "arjun@gmail.com")).isEqualTo(feedback);
		
	}
	
	@Test
	public void testGetAllFeedbacks() {
		Feedback feedback1 = new Feedback();
		feedback1.setId(1);
		feedback1.setComments("Good Items");
		feedback1.setRating(4);
		
		Feedback feedback2 = new Feedback();
		feedback2.setId(2);
		feedback2.setComments("Nice Items");
		feedback2.setRating(4);
		
		Iterable<Feedback> allFeedbacks = feedbackService.getAllFeedbacks();
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.add(feedback1);
		feedbackList.add(feedback2);
		for (Feedback feedback : allFeedbacks) {
			feedbackList.add(feedback);
		}
		assertThat(feedbackList.size()).isEqualTo(2);
		
	}

}
