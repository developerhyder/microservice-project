package com.servicemarket.profile.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.profile.dto.Profile;
import com.servicemarket.profile.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController{


	
	@Autowired
	ProfileService service;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/addtransaction")
	String addTrasaction(@RequestBody Profile profile) {
		return service.addTransaction(profile);
	}
	
	@RequestMapping("/getById/{id}")
	Optional<List<Profile>> getById(@PathVariable Integer id){
		return service.getTransactionById(id);
	}
	@RequestMapping("/transactions")
	Iterable<Profile> retriveTransactions(){
		return service.retrievTransactions();
	}
	
}
