package com.aithinkers.gymmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aithinkers.gymmvc.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	

    // add a method to sort by last name
    public List<Trainer> findAllByOrderByLastNameAsc();

}