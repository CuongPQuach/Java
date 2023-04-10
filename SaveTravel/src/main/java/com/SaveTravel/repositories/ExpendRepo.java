package com.SaveTravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SaveTravel.models.Expend;

public interface ExpendRepo extends CrudRepository<Expend, Long>{
	List<Expend> findAll();
}
