package com.servicemarket.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.service.dto.Service;
import com.servicemarket.service.service.TestService;


@RestController
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	TestService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/add") 
		String addService(@RequestBody Service srv) {
			return service.addService(srv);
	}
	@RequestMapping("/find/{serviceId}")
		Service getServiceById(@PathVariable int serviceId) {
	 	return service.getServiceById(serviceId);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{serviceId}")
		String deleteService(@PathVariable int serviceId) {
		return service.deleteService(serviceId);
	}
	@RequestMapping(method=RequestMethod.GET, value="/all")
		Iterable<Service> getAllServices() {
			return service.getAllServices();
	}
	@RequestMapping(method=RequestMethod.POST, value="/update") 
	String updateService(@RequestBody Service srv) {
		return service.updateService(srv);
}
	
}
