package com.servicemarket.customer.service;

import org.springframework.stereotype.Service;

import com.servicemarket.customer.dto.Customer;
import com.servicemarket.customer.interfaces.CustomerInterface;

@Service
public class CustomerService implements CustomerInterface{

	@Override
	public String signUp(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUserEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String signIn(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getDetailsByCid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
