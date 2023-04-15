package com.dojosandninjasfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjasfinal.models.Dojo;
import com.dojosandninjasfinal.repositories.DojoRepo;

@Service
public class DojoService {
	@Autowired
	 private DojoRepo dRepo;
	
	
	
	public List<Dojo> getall(){
		 return dRepo.findAll();
	 }
	public Dojo getOne(Long id) {
		 Optional<Dojo> s = dRepo.findById(id);
		 
		 if(s.isPresent()) {
			 return s.get();
		 }
		 return null;
	 }
	
	 public Dojo createorupdate(Dojo inpendingDojo) {
		 return dRepo.save(inpendingDojo);
	 }

	 public void deleteDojo(Long dojoId) {
		 dRepo.deleteById(dojoId);
	 }

}
