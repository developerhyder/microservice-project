package com.servicemarket.customer.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicemarket.customer.dto.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	//User findUserByStatusAndName(Integer status, String name);
	
	@Query(value="select count(*) from customer where email= ?1 and password= ?2", nativeQuery=true)
	int getCustomerByCred(String email, String password);
	
	@Query(value="select count(*) from customer where email = ?1 ", nativeQuery=true)
	int getCustomerByEmail(String email);
	
}
