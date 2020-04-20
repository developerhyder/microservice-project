package com.servicemarket.profile.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.servicemarket.profile.dto.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
