package com.servicemarket.fa.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicemarket.fa.dto.Customer;
import com.servicemarket.fa.dto.OtpDetail;
import com.servicemarket.fa.interfaces.OtpDetailInterface;
import com.servicemarket.fa.interfaces.OtpDetailRepositor;
import com.servicemarket.fa.util.SendMail;

@Service
public class OtpService implements OtpDetailInterface{

	@Autowired
	OtpDetailRepositor repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String sendAuthMail(Customer customer) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		OtpDetail otp = new OtpDetail();
		
		otp.setEmail(customer.getEmail());
		otp.setName(customer.getName());
		otp.setPassword(customer.getPassword());
		long currenTime = timestamp.getTime();
		otp.setTimestamp(currenTime);
		Random random = new Random();
		otp.setOtpGen(""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10));
		if(repo.save(otp) == null) {
			return "something went wrong";
		}else {
			//add the content to be sent
			return SendMail.send(customer.getEmail(), "http://localhost:5005/fa/verify/"+otp.getEmail()+"/"+otp.getOtpGen(), otp.getName());
		}
	}

	@Override
	public String verifyLink(String email, String otpValue) {
		int check = repo.validate(email, otpValue);
		
		if(check >= 1) {
			String url = "http://localhost:5001/customer/save";
			Integer otpid = repo.getId(email);
			
			Customer customer = new Customer();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//60000*10 is 1 min*10
			if(timestamp.getTime() > (repo.getTimeStamp(email, otpValue)+600000)) {
				repo.deleteById(otpid);
				return "otp has elapse please re do the sign up";
			}else {
				customer.setEmail(email);
				customer.setName(repo.getName(email, otpValue));
				customer.setPassword(repo.getPassword(email, otpValue));
				repo.deleteById(otpid);
				return restTemplate.postForObject(url, customer, String.class);
			}
			
		}else {
			return "invalid link The link is either expired or invalid";
		}
	}

	
}
