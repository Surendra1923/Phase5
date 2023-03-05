package com.cisco.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.training.entity.Customer;
import com.cisco.training.exception.CustomerNotFoundException;
import com.cisco.training.service.ICustomerService;

@RestController
public class Contraoller {
	
	//inject service layer in controller
		@Autowired
		public ICustomerService custService;
		
		@PostMapping("/insertcustomer")
		public Customer insertCustomer(@RequestBody Customer cust) {
			return custService.insertCustomer(cust);
		}
		
		@GetMapping("/getallcustomers")
		public List<Customer> getAllCustomers(){
			return custService.getAllCustomer();
		}
		
		@GetMapping("/getcustomer/{cusid}")
		public Customer getCustomer(@PathVariable("cusid") Long custid) {
			return custService.getCustomer(custid);
		}
		
		@DeleteMapping("/deletecustomer/{cusid}")
		public void deleteCustomer(@PathVariable("cusid") Long custid) {
			custService.deletCustomer(custid);
		}
		
		public Customer updateCustomer(@PathVariable Long custid,@RequestBody Customer cust) {
			try {
				return custService.updateCustomer(custid, cust);
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cust;
		}

	}

