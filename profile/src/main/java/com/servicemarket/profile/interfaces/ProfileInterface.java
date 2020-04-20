package com.servicemarket.profile.interfaces;

import com.servicemarket.profile.dto.Profile;

public interface ProfileInterface {

	//only 2 methods bcz we can only add transactions and retrieve all of them
	public String addTransaction(Profile profile);
	Iterable<Profile> retrievTransactions();
	
}
