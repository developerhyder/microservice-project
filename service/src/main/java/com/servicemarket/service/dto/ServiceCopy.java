package com.servicemarket.service.dto;



public class ServiceCopy {

	
	Integer serviceId;
	String name;
	Integer cost;
	String description;
	
	public ServiceCopy(Integer serviceId, String name, Integer cost, String description) {
		super();
		this.serviceId = serviceId;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	public ServiceCopy() {
		
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

