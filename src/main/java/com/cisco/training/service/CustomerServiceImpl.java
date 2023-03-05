package com.cisco.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.training.entity.Customer;
import com.cisco.training.exception.CustomerNotFoundException;
import com.cisco.training.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	

	@Override
	public Customer insertCustomer(Customer cust) {
		return custRepo.save(cust);
				
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Long custid, Customer cust) throws CustomerNotFoundException {
		Customer existingCustomer = custRepo.findById(custid).get();
		if(cust != null) {
			//update existing Customer details with new details
			existingCustomer.setCustomerEmail(cust.getCustomerEmail());
			existingCustomer.setCustomerId(cust.getCustomerId());
			existingCustomer.setCustomerName(cust.getCustomerName());
			custRepo.save(existingCustomer);
		}else {
			throw new CustomerNotFoundException("customer not found");
		}
		return existingCustomer;
	}


	@Override
	public void deletCustomer(Long custid) {
		// TODO Auto-generated method stub
		custRepo.deleteById(custid);
	}

	@Override
	public Customer getCustomer(Long custid) {
		// TODO Auto-generated method stub
		return custRepo.findById(custid).get();
	}

}
