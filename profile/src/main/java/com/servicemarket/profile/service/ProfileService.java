package com.servicemarket.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicemarket.profile.dto.Profile;
import com.servicemarket.profile.interfaces.ProfileInterface;
import com.servicemarket.profile.interfaces.ProfileRepository;
@Service
public class ProfileService implements ProfileInterface{

	@Autowired
	ProfileRepository repository;
	
	@Override
	public String addTransaction(Profile profile) {
		repository.save(profile);
		return "Transaction added";
	}

	@Override
	public Iterable<Profile> retrievTransactions() {
		
		return repository.findAll();
	}
	
	public Optional<List<Profile>> getTransactionById(Integer customerId){
		
		return Optional.ofNullable(repository.findByCustomerId(customerId));
	}
}