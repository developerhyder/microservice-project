package com.servicemarket.service.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.servicemarket.service.dto.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {
//use your own custom methods here refer my git repo for that
	@Query(value = "select * from service where name like %:serviceName% or description like %:serviceName%",nativeQuery = true)
	List<Service> findByServiceName(String serviceName);
}
