package com.servicemarket.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicemarket.customer.dto.Customer;
import com.servicemarket.customer.interfaces.CustomerInterface;
import com.servicemarket.customer.interfaces.CustomerRepository;

@Service
public class CustomerService implements CustomerInterface{

	@Autowired
	CustomerRepository repo;

	@Override
	public String signUp(Customer customer) {
		if(getUserEmail(customer.getEmail())){
			return "email exists";
			}
		else{
			repo.save(customer);
		return "successfully signed up";}
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
	}



