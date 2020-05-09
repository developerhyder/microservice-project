package com.servicemarket.fa.interfaces;

import com.servicemarket.fa.dto.Customer;

public interface OtpDetailInterface {

	public String sendAuthMail(Customer customer);
	public String verifyLink(String email, String otpValue);
	
	
}
