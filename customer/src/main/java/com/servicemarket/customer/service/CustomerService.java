package com.servicemarket.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicemarket.customer.dto.Customer;
import com.servicemarket.customer.interfaces.CustomerInterface;
import com.servicemarket.customer.interfaces.CustomerRepository;

@Service
public class CustomerService implements CustomerInterface{

	@Autowired
	CustomerRepository repo;

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String signUp(Customer customer) {
		if(getUserEmail(customer.getEmail())){
			return "email exists";
			}
		else{
			//here we will call 2FA micro service and we will save the details in db from 2FA microservice
			//we will have to remove repo.save()
			//repo.save(customer);
			String url="http://localhost:5005/fa/auth";
			return restTemplate.postForObject(url, customer, String.class);
		
		}
	}
	
	@Override
		public boolean getUserEmail(String email) {
			int e = repo.getCustomerByEmail(email);
			if(e>=1) {
				return true;
			}else {
				return false;
			}
		}

	@Override
	public String signIn(String userName, String password) {
		int k = repo.getCustomerByCred(userName, password);
		if(k>=1) {
			return "login successfull";
		}else {
			return "login failed";
		}
	}
	@Override
	public Optional<Customer> getDetailsByCid(Integer id) {
			return repo.findById(id);
		}

	@Override
	public String save(Customer customer) {
		
		if (repo.save(customer) != null) {
			return "succefully finished the signup";
		}else {
			return "something went wrong during saving process";
		}
	}
	
	
}



