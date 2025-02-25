package com.aithinkers.gymmvc.service;

import java.util.List;


import com.aithinkers.gymmvc.model.WorkoutPlan;

public interface WorkoutPlanService {

	List<WorkoutPlan> findAll();
	
	WorkoutPlan findById(int theId);
	
	void save(WorkoutPlan theWorkoutPlan);
	
	void deleteById(int theId);
	
}