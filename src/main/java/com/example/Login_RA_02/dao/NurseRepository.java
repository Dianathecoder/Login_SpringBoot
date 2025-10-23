package com.example.Login_RA_02.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import model.Nurse;


public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	
	 boolean existsByUserAndPass(String user,String pass);	
	 Optional<Nurse> findByName(String name);
	
}
