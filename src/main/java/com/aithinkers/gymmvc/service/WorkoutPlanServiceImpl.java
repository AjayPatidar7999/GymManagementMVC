package com.aithinkers.gymmvc.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aithinkers.gymmvc.dao.WorkoutPlanRepository;

import com.aithinkers.gymmvc.model.WorkoutPlan;

@Service
public class WorkoutPlanServiceImpl implements WorkoutPlanService {

	private WorkoutPlanRepository workoutPlanRepository;
	
	@Autowired
	public WorkoutPlanServiceImpl(WorkoutPlanRepository theWorkoutPlanRepository) {
		workoutPlanRepository = theWorkoutPlanRepository;
	}
	
	@Override
	public List<WorkoutPlan> findAll() {
		return workoutPlanRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public WorkoutPlan findById(int theId) {
		Optional<WorkoutPlan> result = workoutPlanRepository.findById(theId);
		
	    WorkoutPlan theWorkoutPlan = null;
		
		if (result.isPresent()) {
			theWorkoutPlan = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find WorkoutPlan id - " + theId);
		}
		
		return theWorkoutPlan;
	}

	@Override
	public void save(WorkoutPlan theWorkoutPlan) {
		workoutPlanRepository.save(theWorkoutPlan);
	}

	@Override
	public void deleteById(int theId) {
		workoutPlanRepository.deleteById(theId);
	}

}
