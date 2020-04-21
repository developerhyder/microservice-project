package com.servicemarket.orchestrator.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.orchestrator.dto.Customer;
import com.servicemarket.orchestrator.dto.Profile;
import com.servicemarket.orchestrator.dto.Service;
import com.servicemarket.orchestrator.dto.SignIn;
import com.servicemarket.orchestrator.dto.ViewProfile;
import com.servicemarket.orchestrator.service.OrchestratorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="Orchestrator api", description="it binds the other apis and acts as a main page")
public class OrchestratorController {

	@ApiModelProperty(notes="autowired service for the api")
	@Autowired
	OrchestratorService mainService;
	
	//for the email type verification can be done while taking the input
	@ApiOperation(value="sign up method",notes="the user signup takes place in this method", response=String.class)
	@RequestMapping(method=RequestMethod.POST, value = "/signup")
	String signUp(@RequestBody Customer customer) {
		return mainService.signUp(customer);
	}
	
	//this method will have the data in post the reason being its safe
	@RequestMapping(method=RequestMethod.POST, value="/signin")
	String signIn(@RequestBody SignIn details) {
		return mainService.signIn(details.getEmail(), details.getPassword());
	}
	
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
	@RequestMapping("/buy/{serviceId}/{customerId}")
	String addTransaction(@PathVariable Integer serviceId, @PathVariable Integer customerId) {
		Profile profile = new Profile();
		profile.setCost(mainService.getServiceById(serviceId).getCost());
		profile.setCustomerId(customerId);
		profile.setServiceId(serviceId);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		profile.setTimestamp(ts.toString());
		Random random = new Random();
		String trId = ""+serviceId+customerId+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		profile.setTransactionId(trId);
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
