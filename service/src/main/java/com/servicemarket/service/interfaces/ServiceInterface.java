package com.servicemarket.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.servicemarket.service.dto.Service;

public interface ServiceInterface {

	//be careful with names
	String addService(Service service);
	String deleteService(Integer serviceId);
	Optional<Service> getServiceById(Integer id);
	Iterable<Service> getAllServices();
	String updateService(Service service);
	List<Service> getByServiceName(String name);
	
}
