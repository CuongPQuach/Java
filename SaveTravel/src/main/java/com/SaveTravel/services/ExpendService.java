package com.SaveTravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SaveTravel.models.Expend;
import com.SaveTravel.repositories.ExpendRepo;

@Service
public class ExpendService {
//	 private final ExpendRepo eRepo;
//	 public ExpendService(ExpendRepo eRepo) {
//		 this.eRepo = eRepo; 
//		 }
	 
	 @Autowired
	 private ExpendRepo eRepo;

	 
	 public List<Expend> getall(){
		 return eRepo.findAll();
	 }
	 
	 public Expend getOne(Long id) {
		 Optional<Expend> s = eRepo.findById(id);
		 
		 if(s.isPresent()) {
			 return s.get();
		 }
		 return null;
	 }
	 
	 
	 public Expend createorupdate(Expend inpendingExpend) {
		 return eRepo.save(inpendingExpend);
	 }

	 public void deleteExpend(Long expendId) {
		 eRepo.deleteById(expendId);
	 }
		
		

	 
	 
	 
}

