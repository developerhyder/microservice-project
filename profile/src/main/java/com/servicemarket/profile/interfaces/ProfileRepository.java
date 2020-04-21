package com.servicemarket.profile.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicemarket.profile.dto.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

	List<Profile> findByCustomerId(Integer customerId);

}
