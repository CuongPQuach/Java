package com.dojosandninjasfinal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojosandninjasfinal.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
