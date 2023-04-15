package com.dojosandninjasfinal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojosandninjasfinal.models.Dojo;
import com.dojosandninjasfinal.models.Ninja;


public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	
//	Query repo for Finy frogein key
	List<Ninja> findAllByDojo(Dojo s);
			
	

	
}
