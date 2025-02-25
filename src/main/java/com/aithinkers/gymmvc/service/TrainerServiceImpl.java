package com.aithinkers.gymmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aithinkers.gymmvc.dao.TrainerRepository;

import com.aithinkers.gymmvc.model.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService {

	private TrainerRepository trainerRepository;
	
	@Autowired
	public TrainerServiceImpl(TrainerRepository theTrainerRepository) {
		trainerRepository = theTrainerRepository;
	}
	
	@Override
	public List<Trainer> findAll() {
		return trainerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Trainer findById(int theId) {
		Optional<Trainer> result = trainerRepository.findById(theId);
		
		Trainer theTrainer = null;
		
		if (result.isPresent()) {
			theTrainer = result.get();
		}
		else {
			// we didn't find the trainer
			throw new RuntimeException("Did not find trainer id - " + theId);
		}
		
		return theTrainer;
	}

	@Override
	public void save(Trainer theTrainer) {
		trainerRepository.save(theTrainer);
	}

	@Override
	public void deleteById(int theId) {
		trainerRepository.deleteById(theId);
	}

}
