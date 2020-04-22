package com.servicemarket.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.fa.dto.Customer;
import com.servicemarket.fa.service.OtpService;

@RestController
public class OtpController {

	@Autowired
	OtpService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/fa/auth")
	String authenticate(@RequestBody Customer customer) {
		return service.sendAuthMail(customer);
	}
	
	@RequestMapping("/fa/verify/{email}/{otp_gen}")
	String validate(@PathVariable String email, @PathVariable String otp_gen) {
		
		return service.verifyLink(email, otp_gen);
	}
}
