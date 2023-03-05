package com.cisco.training.service;

import java.util.List;

import com.cisco.training.entity.Customer;
import com.cisco.training.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer insertCustomer(Customer cust);
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(Long custid, Customer cust) throws CustomerNotFoundException;
	
	
	public void deletCustomer(Long custid);
	public Customer getCustomer(Long custid);

}
