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

import com.login.sales.dao.CustomerRepository;
import com.login.sales.model.Customer;
import com.login.sales.model.Feedback;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService custService;
	
	@MockBean
	private CustomerRepository custRepo;
	
	@Test
	public void testSaveCustomer() {
		Customer cust = new Customer();
		cust.setId((long) 1);
		cust.setName("Arjun");
		cust.setEmail("arjun@gmail.com");
		cust.setUsername("arjudutt");
		cust.setPassword("arjun123");
		
		Mockito.when(custRepo.save(cust)).thenReturn(cust);
		assertThat(custService.savecustomer(cust)).isEqualTo(cust);
	}
	
	@Test
	public void testLogin() {
		Customer cust = new Customer();
		cust.setId((long) 1);
		cust.setName("Arjun");
		cust.setEmail("arjun@gmail.com");
		cust.setUsername("arjudutt");
		cust.setPassword("arjun123");
		
		Mockito.when(custRepo.findByUsernameAndPassword("arjudutt", "arjun123")).thenReturn(cust);
		assertThat(custService.login("arjudutt", "arjun123")).isEqualTo(cust);
	}
	
	@Test
	public void testFindspecific() {
		Customer cust = new Customer();
		cust.setId((long) 1);
		cust.setName("Arjun");
		cust.setEmail("arjun@gmail.com");
		cust.setUsername("arjudutt");
		cust.setPassword("arjun123");
		
		Mockito.when(custRepo.findByusername("arjudutt")).thenReturn(cust);
		assertThat(custService.findspecific("arjudutt")).isEqualTo(cust);
	}
	
	@Test
	public void testListAll() {
		Customer cust1 = new Customer();
		cust1.setId((long) 1);
		cust1.setName("Arjun");
		cust1.setEmail("arjun@gmail.com");
		cust1.setUsername("arjudutt");
		cust1.setPassword("arjun123");
		
		Customer cust2 = new Customer();
		cust2.setId((long) 2);
		cust2.setName("Arjun");
		cust2.setEmail("arjun@gmail.com");
		cust2.setUsername("arjudutt");
		cust2.setPassword("arjun123");
		
		Iterable<Customer> allCustList = custService.listall();
		List<Customer> custList = new ArrayList<>();
		custList.add(cust1);
		custList.add(cust2);
		for (Customer cust : allCustList) {
			custList.add(cust);
		}
		assertThat(custList.size()).isEqualTo(2);
	}
}
