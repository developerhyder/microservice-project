package com.servicemarket.service.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.servicemarket.service.interfaces.ServiceInterface;
import com.servicemarket.service.interfaces.ServiceRepository;

@Service
public class TestService implements ServiceInterface {
//package com.servicemarket.service.dto;
	@Autowired
	ServiceRepository repo;

	@Override
	public String deleteService(Integer serviceId) {
		repo.deleteById(serviceId);
		return "Service deleted!";
	}
	
	
	@Override
	public String addService(com.servicemarket.service.dto.Service srv) {
		repo.save(srv);
		return "Service Added!";
	}
	public Optional<com.servicemarket.service.dto.Service> stillWorks(Integer serviceId){
		return Optional.empty();
	}
	@HystrixCommand(fallbackMethod="stillWorks")
	@Override
	public Optional<com.servicemarket.service.dto.Service> getServiceById(Integer serviceId) {
		return repo.findById(serviceId);
	}
	@Override
	public String updateService(com.servicemarket.service.dto.Service srv) {
		repo.save(srv);
		return "Service Added!";
	}
	@Override
	public Iterable<com.servicemarket.service.dto.Service> getAllServices() {
			
		return repo.findAll();
	}
	
	@Override
	public  List<com.servicemarket.service.dto.Service> getByServiceName(String serviceName) {
		return repo.findByServiceName(serviceName);
	}
}
