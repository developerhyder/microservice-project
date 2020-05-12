package com.servicemarket.orchestrator.dto;

public class ProfileView {

	String serviceName;
	Profile profile;
	public ProfileView(String serviceName, Profile profile) {
		super();
		this.serviceName = serviceName;
		this.profile = profile;
	}
	public ProfileView() {
		
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
