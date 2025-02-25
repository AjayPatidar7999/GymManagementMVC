package com.aithinkers.gymmvc.service;

import java.util.List;


import com.aithinkers.gymmvc.model.Trainer;

public interface TrainerService {

	List<Trainer> findAll();
	
	Trainer findById(int theId);
	
	void save(Trainer theTrainer);
	
	void deleteById(int theId);
	
}