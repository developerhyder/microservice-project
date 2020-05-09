package com.servicemarket.fa.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicemarket.fa.dto.OtpDetail;

@Repository
public interface OtpDetailRepositor extends CrudRepository<OtpDetail, Integer>{

	@Query(value="select count(*) from otp_detail where email=?1 and otp_gen= ?2", nativeQuery=true)
	int validate(String email, String otpValue);
	
	@Query(value="select otpid from otp_detail where email=?1", nativeQuery=true)
	Integer getId(String email);
	
	@Query(value="select name from otp_detail where email=?1 and otp_gen=?2", nativeQuery=true)
	String getName(String email, String otpValue);
	
	@Query(value="select password from otp_detail where email=?1 and otp_gen=?2", nativeQuery=true)
	String getPassword(String email, String otpValue);
	
	@Query(value="select timestamp from otp_detail where email=?1 and otp_gen=?2", nativeQuery=true)
	long getTimeStamp(String email,String otp_gen);
	
	@Query(value="select count(*) from customer where email = ?1 ", nativeQuery=true)
	int getCustomerByEmail(String email);
	
	@Query(value="select timestamp from otp_detail where email=?1", nativeQuery=true)
	long getTimeStampNew(String email);
}
