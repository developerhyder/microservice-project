package com.servicemarket.service.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Override
	public com.servicemarket.service.dto.Service getServiceById(Integer serviceId) {
		return repo.findById(serviceId).get();
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
	
}
