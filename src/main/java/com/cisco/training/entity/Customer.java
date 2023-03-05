package com.cisco.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid")
	private Long customerId;
	
	@Column(name = "custname")
	@NonNull
	private String customerName;
	
	@Column(name = "custemail")
	private String customerEmail;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String customerName, String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
}


