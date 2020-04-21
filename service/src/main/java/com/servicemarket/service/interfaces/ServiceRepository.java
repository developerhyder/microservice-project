package com.servicemarket.service.interfaces;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.servicemarket.service.dto.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {
//use your own custom methods here refer my git repo for that
}
