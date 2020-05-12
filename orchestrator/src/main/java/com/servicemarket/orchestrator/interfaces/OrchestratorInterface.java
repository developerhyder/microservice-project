package com.servicemarket.orchestrator.interfaces;

import java.util.List;


import com.servicemarket.orchestrator.dto.Customer;
import com.servicemarket.orchestrator.dto.Profile;
import com.servicemarket.orchestrator.dto.ProfileView;
import com.servicemarket.orchestrator.dto.Service;
import com.servicemarket.orchestrator.dto.UpdatedProfile;
import com.servicemarket.orchestrator.dto.ViewProfile;



public interface OrchestratorInterface {

	
	public Customer getCustomerById(Integer id);
	
	String addService(Service service);
	String deleteService(Integer serviceId);
	Service getServiceById(Integer id);
	List<Service> getAllServices();
	String updateService(Service service);
	
	public String addTransaction(Profile profile, String address);
	public List<Profile> retrievTransactions();
	public List<Profile> getTransactionById(Integer customerId);
	
	public ViewProfile checkProfile(Integer customerId);
	
	public UpdatedProfile getProfile(Integer customerId);
}
