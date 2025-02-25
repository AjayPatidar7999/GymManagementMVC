package com.aithinkers.gymmvc.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.aithinkers.gymmvc.model.Trainer;

import com.aithinkers.gymmvc.service.TrainerService;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

	private TrainerService trainerService;



	public TrainerController(TrainerService theTrainerService) {
		
		trainerService = theTrainerService;
	}

	// add mapping for "/list"

	@GetMapping("/tlist")
	public String listTrainer(Model theModel) {

		// get the employees from db
		List<Trainer> theTrainers = trainerService.findAll();

		// add to the spring model
		theModel.addAttribute("trainers", theTrainers);

		return "Trainer/list-trainers";
	}

	@GetMapping("/tshowFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Trainer theTrainer = new Trainer();

		theModel.addAttribute("trainer", theTrainer);

		return "Trainer/trainer-form";
	}
	
	


	@GetMapping("/tshowFormForUpdate")
	public String showFormForUpdate(@RequestParam("trainerId") int theId,
									Model theModel) {

		// get the employee from the service
		Trainer theTrainer = trainerService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("trainer", theTrainer);

		// send over to our form
		return "Trainer/trainer-form";
	}

	@PostMapping("/tsave")
	public String saveTrainer(@ModelAttribute("trainer") Trainer theTrainer) {

		// save the employee
		trainerService.save(theTrainer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/trainers/tlist";
	}

	@GetMapping("/tdelete")
	public String delete(@RequestParam("trainerId") int theId) {

		// delete the employee
		trainerService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/trainers/tlist";

	}
}