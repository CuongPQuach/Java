package com.dojosandninjasfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjasfinal.models.Dojo;
import com.dojosandninjasfinal.models.Ninja;
import com.dojosandninjasfinal.repositories.NinjaRepo;



@Service
public class NinjaService {
	
	@Autowired
	 private NinjaRepo nRepo;
	
	public List<Ninja> getall(){
		 return nRepo.findAll();
	 }
	 
	 public Ninja getOne(Long id) {
		 Optional<Ninja> s = nRepo.findById(id);
		 
		 if(s.isPresent()) {
			 return s.get();
		 }
		 return null;
	 }
	 
	 public List<Ninja> findNinjaByDojo(Dojo penDojo){
		 return nRepo.findAllByDojo(penDojo);
	 }
	 
	 
//	 public List<Ninja> mapbyDojoId(Long id) {
//		 return nRepo.findbydojoid(id);
//	 }
	 
	 
	 public Ninja createorupdate(Ninja inpendingNinja) {
		 return nRepo.save(inpendingNinja);
	 }

	 public void deleteExpend(Long ninjaId) {
		 nRepo.deleteById(ninjaId);
	 }
	
	
	
	
}
