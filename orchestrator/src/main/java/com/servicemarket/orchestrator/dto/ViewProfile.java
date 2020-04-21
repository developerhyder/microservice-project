package com.servicemarket.orchestrator.dto;

import java.util.ArrayList;
import java.util.List;

public class ViewProfile {

	Customer customer;
	List<Profile> profile = new ArrayList<>();
	public ViewProfile(Customer customer, List<Profile> profile) {
		super();
		this.customer = customer;
		this.profile = profile;
		this.customer.setPassword("");
	}
	
	public ViewProfile() {
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Profile> getProfile() {
		return profile;
	}
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	} 
}
