package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.sales.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
