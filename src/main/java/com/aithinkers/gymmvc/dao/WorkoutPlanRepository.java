package com.aithinkers.gymmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aithinkers.gymmvc.model.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Integer> {

	

    // add a method to sort by last name
    public List<WorkoutPlan> findAllByOrderByLastNameAsc();

}
