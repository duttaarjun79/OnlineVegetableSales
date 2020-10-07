package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.sales.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
