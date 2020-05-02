package com.servicemarket.customer.controller;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.customer.dto.Customer;
import com.servicemarket.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Rest API", description = "Information about customers of our service market organization")
public class CustomerController {
	
	@ApiModelProperty(notes="autowired service for this api")
	@Autowired
	CustomerService service;
	
	@ApiOperation(value = "creating a new customer", 
			notes = "Hit this URL for creating an new customer",
			response = List.class)
	@RequestMapping(method= RequestMethod.POST, value="/signup")
	public String signUp(@RequestBody Customer customer) {
		return service.signUp(customer);
	}
	@ApiOperation(value = "Logging into the customer account", 
			notes = "Hit this URL for logging into the customer account")
	@RequestMapping("/signin/{email}/{password}")
	public String signIn(@PathVariable String email, @PathVariable String password) {
		return service.signIn(email, password);
	}
	@ApiOperation(value = "Find the customer by their id", 
			notes = "Hit this URL for getting the customer by their id")
	@RequestMapping("/{id}")
	Optional<Customer> getDetailsByCid(@PathVariable Integer id){
		return service.getDetailsByCid(id);
	}
	@ApiOperation(value = "for saving the customer", 
			notes = "Hit this URL for saving the customer")
	@RequestMapping(method=RequestMethod.POST,value="/save")
	String saveCustomer(@RequestBody Customer customer) {
		return service.save(customer);
	}
	
}