package com.servicemarket.profile.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

	//profile id is nothing but serial number of the transaction
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer profileId;
	Integer customerId;
	Integer serviceId;
	String timestamp;
	Integer cost;
	String transactionId;
	
	public Profile(Integer profileId, Integer customerId, Integer serviceId, String timestamp, Integer cost,
			String transactionId) {
		super();
		this.profileId = profileId;
		this.customerId = customerId;
		this.serviceId = serviceId;
		this.timestamp = timestamp;
		this.cost = cost;
		this.transactionId = transactionId;
	}
	
	public Profile() {
		
	}

	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
