package com.servicemarket.customer.interfaces;

import com.servicemarket.customer.dto.Customer;

public interface CustomerInterface {
	//This interface will have all the important methods for all the operation 
		//implement this method as a service and add a controller to show all the required request mappings
		//while implementing use a temporary database
		
		//for signup use @RequestBody
		public String signUp(Customer customer);
		
		//this is during 
		public int getUserEmail(String email);
		//for signin use @PathVariable
		public String signIn(String userName, String password);
		
		public Customer getDetailsByCid(Integer id);
}
