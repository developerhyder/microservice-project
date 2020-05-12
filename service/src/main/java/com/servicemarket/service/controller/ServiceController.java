package com.servicemarket.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.service.dto.Service;
import com.servicemarket.service.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/service")
@CrossOrigin(origins="*", allowedHeaders="*")
@Api(value = "Service Rest API", description = "Information about the services that are being provided in the organization")
public class ServiceController {
	
	@ApiModelProperty(notes="autowired service for this api")
	@Autowired
	TestService service;
	
	@ApiOperation(value = "Creating an service", 
			notes = "Hit this URL for creating an new service")
	@RequestMapping(method=RequestMethod.POST, value="/add") 
		String addService(@RequestBody Service srv) {
			return service.addService(srv);
	}
	@ApiOperation(value = "Service by its id", 
			notes = "Hit this URL for getting the service id")
	@RequestMapping("/find/{serviceId}")
		Optional<Service> getServiceById(@PathVariable int serviceId) {
	 	return service.getServiceById(serviceId);
	}
	@ApiOperation(value = "Deleting an service", 
			notes = "Hit this URL for deleting an service")
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{serviceId}")
		String deleteService(@PathVariable int serviceId) {
		return service.deleteService(serviceId);
	}
	@ApiOperation(value = "Getting all services", 
			notes = "Hit this URL for getting all services")
	@RequestMapping(method=RequestMethod.GET, value="/all")
		Iterable<Service> getAllServices() {
			return service.getAllServices();
	}
	@ApiOperation(value = "Update an service", 
			notes = "Hit this URL for updating an service ")
	@RequestMapping(method=RequestMethod.POST, value="/update") 
	String updateService(@RequestBody Service srv) {
		return service.updateService(srv);
	}
	
	@ApiOperation(value="Getting all Services By Name",notes = "Hit this URL for getting the services by name")
	@RequestMapping("/serviceByName/{serviceName}")
	List<Service> getServiceByName(@PathVariable String serviceName){
		return service.getByServiceName(serviceName);
	}
}