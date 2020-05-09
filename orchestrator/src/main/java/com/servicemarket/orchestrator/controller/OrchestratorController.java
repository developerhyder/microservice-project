package com.servicemarket.orchestrator.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.orchestrator.dto.Profile;
import com.servicemarket.orchestrator.dto.Service;

import com.servicemarket.orchestrator.dto.ViewProfile;
import com.servicemarket.orchestrator.service.OrchestratorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@Api(value="Orchestrator api", description="it binds the other apis and acts as a main page")
public class OrchestratorController {

	@ApiModelProperty(notes="autowired service for the api")
	@Autowired
	OrchestratorService mainService;
	
	//for the email type verification can be done while taking the input
	
	@ApiOperation(value="add a service", notes="adding the service to service mircroservice")
	@RequestMapping(method=RequestMethod.POST, value="/addService/{password}")
	String addService(@RequestBody Service service, @PathVariable String password) {
		//System.out.println(service.getName()+"check - 2222");
		if(!mainService.verify(password)) {
			return "permission denied"; 
		}else {
			System.out.println(service.getName());
			return mainService.addService(service);
		}
	}
	@RequestMapping(method=RequestMethod.POST, value="/updateService/{password}")
	String updateService(@PathVariable String password, @RequestBody Service service) {
		if(mainService.verify(password)) {
			return mainService.updateService(service);
		}else {
			return "permission denied";
		}
	}
	@RequestMapping("/deleteService/{serviceId}/{password}")
	String deleteService(@PathVariable String password, @PathVariable Integer serviceId){
		return mainService.deleteService(serviceId);
	}
	@RequestMapping("/getAllServices")
	List<Service> getAllService(){
		return mainService.getAllServices();
	}
	@RequestMapping("/getServiceById/{serviceId}")
	Service getServiceById(@PathVariable Integer serviceId) {
		return mainService.getServiceById(serviceId);
	}
	@RequestMapping("/buy/{transactionId}/{serviceId}/{customerId}")
	String addTransaction(@PathVariable String transactionId, @PathVariable Integer serviceId, @PathVariable Integer customerId) {
		Profile profile = new Profile();
		if(transactionId.equals("none")) {
			return "some error has occured while payment";
		}
		profile.setCost(mainService.getServiceById(serviceId).getCost());
		profile.setCustomerId(customerId);
		profile.setServiceId(serviceId);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		profile.setTimestamp(ts.toString());
		profile.setTransactionId(transactionId);
		return mainService.addTransaction(profile);
	}
	
	@RequestMapping("/getTransactionById/{customerId}")
	List<Profile> getTransactionsById(@PathVariable Integer customerId){
		return mainService.getTransactionById(customerId);
	}
	
	@RequestMapping("/getAllTransactions/{password}")
	List<Profile> getAllTransactions(@PathVariable String password){
		return mainService.retrievTransactions();
	}
	@RequestMapping("/viewProfile/{customerId}")
	ViewProfile profileOfCustomer(@PathVariable Integer customerId) {
		return mainService.checkProfile(customerId);
	}
}
