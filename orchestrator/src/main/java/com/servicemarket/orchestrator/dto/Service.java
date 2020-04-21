package com.servicemarket.orchestrator.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer serviceId;
	String name;
	Integer cost;
	String description;
	
	public Service(Integer serviceId, String name, Integer cost, String description) {
		super();
		this.serviceId = serviceId;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	public Service() {
		
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

