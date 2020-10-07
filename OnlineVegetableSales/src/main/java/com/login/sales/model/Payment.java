package com.login.sales.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payment")
public class Payment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
private String card_number;
private String cvv;
@ManyToOne(fetch=FetchType.LAZY, optional=false)
@JoinColumn(name="cust_id")
@JsonIgnore
private Customer customer;
public Customer getCustomer() {
return customer;
}
 public void setCustomer(Customer customer) {
this.customer = customer;
}
public Payment() {
super();
}
public Payment(long id, String name, String card_number, String cvv) {
super();
this.id = id;
this.name = name;
this.card_number = card_number;
this.cvv = cvv;
}
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getCard_number() {
return card_number;
}
public void setCard_number(String card_number) {
this.card_number = card_number;
}
public String getCvv() {
return cvv;
}
public void setCvv(String cvv) {
this.cvv = cvv;
}
@Override
public String toString() {
return "Payment [id=" + id + ", name=" + name + ", card_number=" + card_number + ", cvv=" + cvv + ", customer=" + customer + "]";
}
}
