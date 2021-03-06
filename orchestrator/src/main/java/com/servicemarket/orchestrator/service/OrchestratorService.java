package com.servicemarket.orchestrator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.servicemarket.orchestrator.dto.Customer;
import com.servicemarket.orchestrator.dto.Profile;
import com.servicemarket.orchestrator.dto.ProfileView;
import com.servicemarket.orchestrator.dto.UpdatedProfile;
import com.servicemarket.orchestrator.dto.ViewProfile;
import com.servicemarket.orchestrator.interfaces.OrchestratorInterface;
import com.servicemarket.orchestrator.util.SendEmail;

@Service
public class OrchestratorService implements OrchestratorInterface{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Customer getCustomerById(Integer id) {
		String url = "http://localhost:5001/customer/"+id;
		return restTemplate.getForObject(url, Customer.class);
	}

	@Override
	public String addService(com.servicemarket.orchestrator.dto.Service service) {
		
		String url = "http://localhost:5003/service/add";
		return restTemplate.postForObject(url, service, String.class);
	}

	@Override
	public String deleteService(Integer serviceId) {
		String url = "http://localhost:5003/service/delete/"+serviceId;
		restTemplate.delete(url);
		return "deleted record";
	}

	public com.servicemarket.orchestrator.dto.Service stillWorks(Integer id){
		return null;
	}
	
	@HystrixCommand(fallbackMethod="stillWorks")
	@Override
	public com.servicemarket.orchestrator.dto.Service getServiceById(Integer id) {
		String url = "http://localhost:5003/service/find/"+id;
		com.servicemarket.orchestrator.dto.Service serv = new com.servicemarket.orchestrator.dto.Service();
		serv= restTemplate.getForObject(url, com.servicemarket.orchestrator.dto.Service.class);
		
		return serv;
	}

	@Override
	public List<com.servicemarket.orchestrator.dto.Service> getAllServices() {
		String url = "http://localhost:5003/service/all";
		com.servicemarket.orchestrator.dto.Service[] allServices = restTemplate.getForObject(url, com.servicemarket.orchestrator.dto.Service[].class);
		return Arrays.asList(allServices);
	}

	@Override
	public String updateService(com.servicemarket.orchestrator.dto.Service service) {
		String url="http://localhost:5003/service/update";
		
		return restTemplate.postForObject(url, service, String.class);
	}

	@Override
	public String addTransaction(Profile profile, String address) {
		String url="http://localhost:5002/profile/addtransaction";
		//get transaction by id
		Customer customer = new Customer();
		com.servicemarket.orchestrator.dto.Service ser = new com.servicemarket.orchestrator.dto.Service();
		ser = getServiceById(profile.getServiceId());
		customer = getCustomerById(profile.getCustomerId());
		SendEmail.send(customer.getEmail(), profile.getTransactionId(), profile.getServiceId(), customer.getName(), profile.getCost(), ser.getName(), address);
		return restTemplate.postForObject(url, profile, String.class);
	}

	@Override
	public List<Profile> retrievTransactions() {

		String url = "http://localhost:5002/profile/transactions";
		Profile[] profileList = restTemplate.getForObject(url, Profile[].class);
		return Arrays.asList(profileList);
	}

	@Override
	public List<Profile> getTransactionById(Integer customerId) {
		String url = "http://localhost:5002/profile/getById/"+customerId;
		return Arrays.asList(restTemplate.getForObject(url, Profile[].class));
	}
	public boolean verify(String password) {
		if(password.equals("password")) {
			return true;
		}else return false;
	}

	@Override
	public ViewProfile checkProfile(Integer customerId) {
		Customer customer = new Customer();
		customer = getCustomerById(customerId);
		List<Profile> profileList = new ArrayList<>();
		profileList = getTransactionById(customerId);
		return new ViewProfile(customer, profileList);	
	}

	@Override
	public UpdatedProfile getProfile(Integer customerId) {
		Customer customer = new Customer();
		customer = getCustomerById(customerId);
		List<Profile> transactions = new ArrayList<>();
		UpdatedProfile upProfile = new UpdatedProfile();
		upProfile.setCustomer(customer);
		transactions = getTransactionById(customerId);
		for(Profile pr : transactions) {
			
			com.servicemarket.orchestrator.dto.Service serv = getServiceById(pr.getServiceId());
			
			String serviceName = "";
			if(serv==null) {
				serviceName = "service not available";
			}else {
				serviceName = serv.getName();
			}
			upProfile.addProfile(new ProfileView(serviceName, pr));
		}
		upProfile.getCustomer().setPassword("");
		return upProfile;
	}
	
	
}
