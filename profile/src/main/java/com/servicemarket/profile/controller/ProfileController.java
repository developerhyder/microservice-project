package com.servicemarket.profile.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/profile")
@Api(value = "Service Rest API", description = "Information about the profiles that are being provided in the organization")
public class ProfileController{
	@ApiModelProperty(notes="autowired service for this api")
	@Autowired
	ProfileService service;
	
	@ApiOperation(value = "Make a Transations", 
			notes = "Hit this URL for making an transaction")
	@RequestMapping(method=RequestMethod.POST,value="/addtransaction")
	String addTrasaction(@RequestBody Profile profile) {
		return service.addTransaction(profile);
	}
	@ApiOperation(value = "Transaction by Id", 
			notes = "Hit this URL for getting an transaction by id")
	@RequestMapping("/getById/{id}")
	Optional<List<Profile>> getById(@PathVariable Integer id){
		return service.getTransactionById(id);
	}
	@ApiOperation(value = "Retrive an transaction", 
			notes = "Hit this URL for retriving an transaction")
	@RequestMapping("/transactions")
	Iterable<Profile> retriveTransactions(){
		return service.retrievTransactions();
	}
	
}