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
import com.sun.istack.NotNull;

	@Entity
	@Table(name="adderess")
	public class Address {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String houseNo;
		private String locality;
		private String city;
		private String state;
		@NotNull
		private String pinCode;
		@ManyToOne(fetch=FetchType.LAZY, optional=false)
		@JoinColumn(name="cust_id")
		@JsonIgnore
		private Customer customer;
		
		public Address() {
		}
		
		public Address(long id, String houseNo, String locality, String city, String state, String pinCode,
				Customer customer) {
			super();
			this.id = id;
			this.houseNo = houseNo;
			this.locality = locality;
			this.city = city;
			this.state = state;
			this.pinCode = pinCode;
			this.customer = customer;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(String houseNo) {
			this.houseNo = houseNo;
		}

		public String getLocality() {
			return locality;
		}

		public void setLocality(String locality) {
			this.locality = locality;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPinCode() {
			return pinCode;
		}

		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Address [id=" + id + ", houseNo=" + houseNo + ", locality=" + locality + ", city=" + city
					+ ", state=" + state + ", pinCode=" + pinCode + ", customer=" + customer + "]";
		}

		
}
