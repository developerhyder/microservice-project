package com.servicemarket.orchestrator.dto;

import java.util.ArrayList;
import java.util.List;

public class UpdatedProfile {
	Customer customer;
	List<ProfileView> profileView = new ArrayList<>();;
	public UpdatedProfile(Customer customer, List<ProfileView> profileView) {
		
		this.customer = customer;
		this.customer.setPassword("");
		this.profileView = profileView;
	}
	public UpdatedProfile() {

	}
	
	public void addProfile(ProfileView pv) {
		profileView.add(pv);
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<ProfileView> getProfileView() {
		return profileView;
	}
	public void setProfileView(List<ProfileView> profileView) {
		this.profileView = profileView;
	}
	
}
