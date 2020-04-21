package com.servicemarket.profile.interfaces;

import java.util.List;
import java.util.Optional;

import com.servicemarket.profile.dto.Profile;

public interface ProfileInterface {

	//only 2 methods bcz we can only add transactions and retrieve all of them
		public String addTransaction(Profile profile);
		public Iterable<Profile> retrievTransactions();
		public Optional<List<Profile>> getTransactionById(Integer customerId);
		
	
}
